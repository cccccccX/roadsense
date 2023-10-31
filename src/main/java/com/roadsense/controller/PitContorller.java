package com.roadsense.controller;

import com.roadsense.pojo.Pit;
import com.roadsense.service.PitService;
import com.roadsense.utils.CodeEnum;
import com.roadsense.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 11:12
 */
@RestController
@RequestMapping("/pits")
public class PitContorller {

    @Autowired
    private PitService pitService;

    @GetMapping
    public Result selectAll(){
        List<Pit> pits = pitService.selectAll();
        if (pits == null){
            return new Result(CodeEnum.FAILED.getCode(), null,"查询失败~");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), pits,CodeEnum.SUCCESS.getMessage());
    }

}
