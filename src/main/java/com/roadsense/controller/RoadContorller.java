package com.roadsense.controller;

import com.roadsense.mapper.RoadMapper;
import com.roadsense.pojo.Road;
import com.roadsense.service.RoadService;
import com.roadsense.utils.CodeEnum;
import com.roadsense.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * author  Edith
 * created  2023/10/31 10:25
 */
@RestController
@RequestMapping("/roads")
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

}
