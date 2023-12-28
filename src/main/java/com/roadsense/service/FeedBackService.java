package com.roadsense.service;

import com.roadsense.common.result.PageResult;
import com.roadsense.entity.dto.FeedBackPageQueryDTO;
import com.roadsense.entity.dto.FeedBackSaveDTO;
import com.roadsense.entity.vo.FeedBackSuccessCountVO;
import com.roadsense.entity.vo.FeedBackUnProcessedVO;

/**
 * author  Edith
 * created  2023/12/26 18:03
 */
public interface FeedBackService {

    /**
     * 统计有效用户反馈数
     * @return
     */
    FeedBackSuccessCountVO successCount();

    /**
     * 当前待审核的数量
     * @return
     */
    FeedBackUnProcessedVO unprocessedCount();

    /**
     * 反馈记录分页查询
     * @param feedBackPageQueryDTO
     * @return
     */
    PageResult pageQuery(FeedBackPageQueryDTO feedBackPageQueryDTO);



    /**
     * 分页查询我的反馈记录
     * @param feedBackPageQueryDTO
     * @return
     */
    PageResult myPageList(FeedBackPageQueryDTO feedBackPageQueryDTO);

    /**
     * 提交反馈
     * @param feedBackSaveDTO
     */
    void save(FeedBackSaveDTO feedBackSaveDTO);
}
