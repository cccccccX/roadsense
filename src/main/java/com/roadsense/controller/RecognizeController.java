package com.roadsense.controller;

import com.roadsense.entity.pojo.Pit;
import com.roadsense.entity.pojo.Road;
import com.roadsense.service.PitService;
import com.roadsense.service.RecognizeService;
import com.roadsense.service.RoadService;
import com.roadsense.common.result.CodeEnum;
import com.roadsense.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 10:00
 */
@RestController
@RequestMapping("/api/recognizes")
public class RecognizeController {

    @Autowired
    private RoadService roadService;
    @Autowired
    private RecognizeService recognizeService;
    @Autowired
    private PitService pitService;

    @GetMapping("/{roadName}")
    @Transactional
    public Result rec(@PathVariable String roadName){
        Road road = roadService.getRoadId(roadName);
        if (road == null){
            return new Result(CodeEnum.NOROAD.getCode(), null,CodeEnum.NOROAD.getMessage());
        }
        List<Pit> pits = recognizeService.recognize(road.getRoadId());

        boolean flag = pitService.inserts(pits);
        if (!flag){
            return new Result(CodeEnum.FAILED.getCode(), null,"插入失败");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), null,CodeEnum.SUCCESS.getMessage());
    }




}
