package com.roadsense.service.impl;

import com.roadsense.constant.FeedBackConstant;
import com.roadsense.mapper.FeedbackMapper;
import com.roadsense.service.FeedBackService;
import com.roadsense.vo.FeedBackSuccessCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author  Edith
 * created  2023/12/26 18:03
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

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
}