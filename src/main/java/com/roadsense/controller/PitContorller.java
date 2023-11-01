package com.roadsense.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.roadsense.pojo.Pit;
import com.roadsense.service.PitService;
import com.roadsense.utils.CodeEnum;
import com.roadsense.utils.Result;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public Result selectAll(){
        List<Pit> pits = pitService.selectAll();
        if (pits == null){
            return new Result(CodeEnum.FAILED.getCode(), null,"查询失败~");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), pits,CodeEnum.SUCCESS.getMessage());
    }

    /**
     * 按条件筛选、按关键词搜索。
     * @return
     */
    @GetMapping
    public Result select(@RequestBody Pit pit){
        List<Pit> pits = pitService.select(pit);
        if (pits == null){
            return new Result(CodeEnum.FAILED.getCode(), null,"查找失败，请重试");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), pits,CodeEnum.SUCCESS.getMessage());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Result deleteById(@PathVariable Long id){
        boolean flag = pitService.deleteById(id);
        if (!flag){
            return new Result(CodeEnum.FAILED.getCode(), null,"删除失败~请重试");
        }
        return new Result(CodeEnum.SUCCESS.getCode(), null,CodeEnum.SUCCESS.getMessage());
    }

}
