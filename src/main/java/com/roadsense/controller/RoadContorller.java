package com.roadsense.controller;

import com.roadsense.entity.pojo.Road;
import com.roadsense.service.RoadService;
import com.roadsense.common.result.CodeEnum;
import com.roadsense.common.result.Result;
import com.roadsense.entity.vo.RoadHealthyVO;
import com.roadsense.entity.vo.RoadPitCountVO;
import com.roadsense.entity.vo.RoadRepairedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * author  Edith
 * created  2023/10/31 10:25
 */
@RestController
@RequestMapping("/api/road")
@Api(tags = "道路相关接口")
@Slf4j
public class RoadContorller {
    @Autowired
    private RoadService roadService;

    @PostMapping
    @Transactional
    public Result insert(@RequestBody Road road){
        boolean flag = roadService.insert(road);
        if (!flag){
            return new Result(CodeEnum.FAILED.getCode(), null,"新增道路失败~请重试");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), null,CodeEnum.SUCCESS.getMessage());
    }

    @GetMapping("/{roadName}")
    public Result getRoad(@PathVariable String roadName){
        Road road = roadService.getRoadId(roadName);
        if (road == null){
            return new Result(CodeEnum.FAILED.getCode(), null,"查询失败~请重试道路名");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), road,CodeEnum.SUCCESS.getMessage());
    }

    /**
     * 街道坑洼数量统计
     * @return
     */
    @GetMapping("/pitCount")
    @ApiOperation("街道坑洼数量统计")
    public Result pitCount(){
        log.info("街道坑洼数量统计...");
        RoadPitCountVO roadPitCountVO = roadService.pitCount();
        return new Result(CodeEnum.SUCCESS.getCode(), roadPitCountVO, CodeEnum.SUCCESS.getMessage());
    }



    @GetMapping("/healthy")
    @ApiOperation("各街道健康指数统计")
    public Result healthy(){
        log.info("各街道健康指数统计...");
        RoadHealthyVO roadHealthyVO =  roadService.healthy();
        return new Result(CodeEnum.SUCCESS.getCode(), roadHealthyVO, CodeEnum.SUCCESS.getMessage());
    }


    @GetMapping("/repairedPits")
    @ApiOperation("各街道维护坑洼数量统计")
    public Result repairedPits() {
        log.info("各街道维护坑洼数量统计...");
        RoadRepairedVO roadRepairedVO =  roadService.repairedPits();
        return new Result(CodeEnum.SUCCESS.getCode(), roadRepairedVO, CodeEnum.SUCCESS.getMessage());
    }


}
