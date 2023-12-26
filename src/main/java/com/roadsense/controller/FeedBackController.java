package com.roadsense.controller;

import com.roadsense.common.result.Result;
import com.roadsense.service.FeedBackService;
import com.roadsense.vo.FeedBackSuccessCountVO;
import com.roadsense.vo.FeedBackUnProcessedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author  Edith
 * created  2023/12/26 18:00
 */
@RestController
@RequestMapping("/feedback")
@Api(tags = "反馈相关接口")
@Slf4j
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @GetMapping("/successCount")
    @ApiOperation("用户有效反馈数")
    public Result successCount(){
        log.info("用户有效反馈数...");
        FeedBackSuccessCountVO feedBackSuccessCountVO = feedBackService.successCount();
        return Result.ok(feedBackSuccessCountVO);
    }


    @GetMapping("/unprocessedCount")
    @ApiOperation("当前待审核")
    public Result unprocessedCount(){
        log.info("当前待审核...");
        FeedBackUnProcessedVO feedBackUnProcessedVO = feedBackService.unprocessedCount();
        return Result.ok(feedBackUnProcessedVO);
    }


}
