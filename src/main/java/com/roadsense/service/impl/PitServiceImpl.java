package com.roadsense.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roadsense.mapper.PitMapper;
import com.roadsense.pojo.Pit;
import com.roadsense.service.PitService;
import com.roadsense.vo.PitTypeCountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 9:35
 */
@Service
public class PitServiceImpl implements PitService {

    @Autowired
    private PitMapper pitMapper;

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
}
