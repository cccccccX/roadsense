package com.roadsense.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.roadsense.common.result.PageResult;
import com.roadsense.constant.RepairedConstant;
import com.roadsense.dto.PitPageQueryDTO;
import com.roadsense.mapper.PitMapper;
import com.roadsense.mapper.RepairMapper;
import com.roadsense.pojo.Pit;
import com.roadsense.pojo.Repair;
import com.roadsense.service.PitService;
import com.roadsense.vo.PitAmountVO;
import com.roadsense.vo.PitRepairedVO;
import com.roadsense.vo.PitTypeCountVO;
import com.roadsense.vo.PitUnRepairedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 9:35
 */
@Service
public class PitServiceImpl implements PitService {

    @Autowired
    private PitMapper pitMapper;
    @Autowired
    private RepairMapper repairMapper;

    /**
     * 插入多个坑洼信息
     * @param pits
     * @return
     */
    @Override
    public boolean inserts(List<Pit> pits) {
        int cnt = 0;
        for (Pit pit : pits){
            cnt += pitMapper.insert(pit);
        }
        return cnt == pits.size();
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Pit> selectAll() {
        List<Pit> pits = pitMapper.selectList(null);
        return pits;
    }


    /**
     * 按条件筛选、按关键词搜索。
     * @param pit
     * @return
     */
    @Override
    public List<Pit> select(Pit pit) {
        LambdaQueryWrapper<Pit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(pit.getRoadId() != null,Pit::getRoadId,pit.getRoadId());
        lqw.eq(pit.getDegree() != null,Pit::getDegree,pit.getDegree());
        lqw.like(pit.getDataSource() != null,Pit::getDataSource,pit.getDataSource());
        lqw.like(pit.getCategory() != null,Pit::getCategory,pit.getCategory());
        lqw.like(pit.getNotes() != null,Pit::getNotes,pit.getNotes());
        lqw.eq(pit.getPitId() != null,Pit::getPitId,pit.getPitId());

        List<Pit> pits = pitMapper.selectList(lqw);

        return pits;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(Long id) {
        int row = pitMapper.deleteById(id);
        return row == 1;
    }


    /**
     * 坑洼类别统计
     * @return
     */
    @Override
    public List<PitTypeCountVO> typeCount() {
        List<PitTypeCountVO> pitTypeCountVOS = pitMapper.countCategory();
        return pitTypeCountVOS;
    }


    /**
     * 获取坑洼总数
     * @return
     */
    @Override
    public PitAmountVO countAll() {
        Integer cnt = pitMapper.countAll();
        PitAmountVO pitAmountVO = new PitAmountVO();
        pitAmountVO.setPitCount(cnt);
        return pitAmountVO;
    }


    /**
     * 处理坑洼数
     * @return
     */
    @Override
    public PitRepairedVO repairedPits() {
        Integer cnt = repairMapper.countByStatus(RepairedConstant.REPAIR_COMPLET);
        PitRepairedVO pitRepairedVO = new PitRepairedVO();
        pitRepairedVO.setRepaired(cnt);
        return pitRepairedVO;
    }


    /**
     * 当前待处理坑洼数
     * @return
     */
    @Override
    public PitUnRepairedVO unRepairedCount() {
        List<Integer> list = repairMapper.getDistinctPitIds();

        Integer cnt = pitMapper.countByNotPitId(list);

        PitUnRepairedVO pitUnRepairedVO = new PitUnRepairedVO();
        pitUnRepairedVO.setUnrepaired(cnt);
        return pitUnRepairedVO;
    }


    /**
     * 坑洼分页查询
     * @param pitPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(PitPageQueryDTO pitPageQueryDTO) {
        PageHelper.startPage(pitPageQueryDTO.getPageNum(), pitPageQueryDTO.getPageSize());

        Page<Pit> page = pitMapper.pageQuery(pitPageQueryDTO);

        PageResult pageResult = new PageResult();
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(page.getResult());

        return pageResult;
    }

    /**
     * 坑洼修复
     * @param pitID
     */
    @Override
    @Transactional
    public void changeRepairStatus(Integer pitID) {
        Pit pit = pitMapper.selectById(pitID);
        int status = pit.getRepairStatus();
        int targetStatus = status;

        if (status == 0){
            //需要插入
            targetStatus = 1;
            Repair repair = new Repair();
            repair.setPitId(pit.getPitId());
            repair.setRepairState(RepairedConstant.IN_REPAIR);
            //TODO 这里需要设置一个处理人id, 需要登录拦截用local thread获得
            repair.setHandleTime(LocalDateTime.now());
            repairMapper.insert(repair);
        }else if (status == 1){
            targetStatus = 2;
            Repair repair = repairMapper.selectByPitId(pit.getPitId());
            repair.setRepairState(RepairedConstant.REPAIR_COMPLET);
            repair.setHandleTime(LocalDateTime.now());
            repairMapper.updateById(repair);
        }else{
            return;
        }

        pit.setRepairStatus(targetStatus);
        pitMapper.updateById(pit);


    }
}
