package com.roadsense.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.roadsense.common.result.PageResult;
import com.roadsense.constant.FeedBackConstant;
import com.roadsense.dto.FeedBackPageQueryDTO;
import com.roadsense.mapper.FeedbackMapper;
import com.roadsense.mapper.PitMapper;
import com.roadsense.pojo.Feedback;
import com.roadsense.pojo.Pit;
import com.roadsense.service.FeedBackService;
import com.roadsense.vo.FeedBackPageVO;
import com.roadsense.vo.FeedBackSuccessCountVO;
import com.roadsense.vo.FeedBackUnProcessedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author  Edith
 * created  2023/12/26 18:03
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private PitMapper pitMapper;

    /**
     * 统计有效用户反馈数
     * @return
     */
    @Override
    public FeedBackSuccessCountVO successCount() {
        Integer cnt = feedbackMapper.countByStatus(FeedBackConstant.VERIFY_COMPLEAT);
        FeedBackSuccessCountVO feedBackSuccessCountVO = new FeedBackSuccessCountVO();
        feedBackSuccessCountVO.setSuccessFeedback(cnt);
        return feedBackSuccessCountVO;
    }

    /**
     * 当前待审核的数量
     * @return
     */
    @Override
    public FeedBackUnProcessedVO unprocessedCount() {
        Integer cnt = feedbackMapper.countByStatus(FeedBackConstant.DURING_VERIFY);
        FeedBackUnProcessedVO feedBackUnProcessedVO = new FeedBackUnProcessedVO();
        feedBackUnProcessedVO.setUnProcessed(cnt);
        return feedBackUnProcessedVO;
    }


    /**
     * 反馈记录分页查询
     * @param feedBackPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(FeedBackPageQueryDTO feedBackPageQueryDTO) {
        PageHelper.startPage(feedBackPageQueryDTO.getPageNum(), feedBackPageQueryDTO.getPageSize());
        Feedback temp = new FeedBackPageVO();
        BeanUtils.copyProperties(feedBackPageQueryDTO, temp);
        Page<Feedback> page = feedbackMapper.list(temp);

        List<FeedBackPageVO> feedBackPageVOS = new ArrayList<>();
        List<Feedback> result = page.getResult();
        for (Feedback feedback : result){
            FeedBackPageVO feedBackPageVO = new FeedBackPageVO();
            BeanUtils.copyProperties(feedback, feedBackPageVO);
            if (feedBackPageVO.getPitId() != null){
                Pit pit = pitMapper.selectById(feedBackPageVO.getPitId());
                feedBackPageVO.setRepairStatus(pit.getRepairStatus());
            }
            feedBackPageVOS.add(feedBackPageVO);
        }

        PageResult pageResult = new PageResult();
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(feedBackPageVOS);
        return pageResult;
    }
}
