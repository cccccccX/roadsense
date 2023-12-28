package com.roadsense.controller;

import com.roadsense.common.result.PageResult;
import com.roadsense.entity.dto.PitPageQueryDTO;
import com.roadsense.entity.pojo.Pit;
import com.roadsense.service.PitService;
import com.roadsense.common.result.CodeEnum;
import com.roadsense.common.result.Result;
import com.roadsense.entity.vo.PitAmountVO;
import com.roadsense.entity.vo.PitRepairedVO;
import com.roadsense.entity.vo.PitTypeCountVO;
import com.roadsense.entity.vo.PitUnRepairedVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 11:12
 */
@RestController
@RequestMapping("/api/pothole")
@Api(tags = "坑洼相关接口")
@Slf4j
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


    @GetMapping("/typeCount")
    @ApiOperation("坑洼类别统计")
    public Result typeCount(){
        log.info("坑洼类别统计...");
        List<PitTypeCountVO> list = pitService.typeCount();
        return new Result(CodeEnum.SUCCESS.getCode(), list, CodeEnum.SUCCESS.getMessage());
    }


    @GetMapping("/amount")
    @ApiOperation("坑洼总数")
    public Result amount(){
        log.info("坑洼总数...");
        PitAmountVO pitAmountVO = pitService.countAll();
        return new Result(CodeEnum.SUCCESS.getCode(), pitAmountVO, CodeEnum.SUCCESS.getMessage());
    }

    @GetMapping("/repaired")
    @ApiOperation("处理坑洼数")
    public Result repairedPits(){
        log.info("处理坑洼数...");
        PitRepairedVO pitRepairedVO = pitService.repairedPits();
        return new Result(CodeEnum.SUCCESS.getCode(), pitRepairedVO, CodeEnum.SUCCESS.getMessage());
    }


    @GetMapping("/unrepairedCount")
    @ApiOperation("当前待处理修复的坑洼数")
    public Result unrepairedCount(){
        log.info("当前待处理修复的坑洼数...");
        PitUnRepairedVO pitUnRepairedVO = pitService.unRepairedCount();
        return Result.ok(pitUnRepairedVO);
    }


    @GetMapping("/page")
    @ApiOperation("坑洼分页查询")
    public Result page( PitPageQueryDTO pitPageQueryDTO){
        log.info("坑洼分页查询, {}", pitPageQueryDTO);
        PageResult pageResult = pitService.pageQuery(pitPageQueryDTO);
        return Result.ok(pageResult);
    }

    @PutMapping("/{pitID}")
    @ApiOperation("坑洼修复")
    public Result changeRepairStatus(@PathVariable Integer pitID){
        log.info("坑洼修复, {}", pitID);
        pitService.changeRepairStatus(pitID);
        return Result.ok(null);
    }

}
