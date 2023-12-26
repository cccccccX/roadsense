package com.roadsense.service;

import com.roadsense.vo.FeedBackSuccessCountVO;
import com.roadsense.vo.FeedBackUnProcessedVO;

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
}
