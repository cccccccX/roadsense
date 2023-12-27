package com.roadsense.controller;

import com.roadsense.common.result.PageResult;
import com.roadsense.common.result.Result;
import com.roadsense.entity.dto.RepairPageDTO;
import com.roadsense.service.RepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author  Edith
 * created  2023/12/27 20:51
 */
@RestController
@RequestMapping("/repair")
@Slf4j
@Api(tags = "维护坑洼相关接口")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping
    @ApiOperation("维护记录分页查询")
    public Result page(RepairPageDTO repairPageDTO){
        log.info("维护记录分页查询, {}", repairPageDTO);
        PageResult pageResult = repairService.pageQuery(repairPageDTO);
        return Result.ok(pageResult);
    }

}
