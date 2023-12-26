package com.roadsense.service;

import com.roadsense.common.result.PageResult;
import com.roadsense.dto.PitPageQueryDTO;
import com.roadsense.pojo.Pit;
import com.roadsense.vo.PitAmountVO;
import com.roadsense.vo.PitRepairedVO;
import com.roadsense.vo.PitTypeCountVO;
import com.roadsense.vo.PitUnRepairedVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 9:34
 */
public interface PitService {

    @Transactional
    public boolean inserts(List<Pit> pits);

    public List<Pit> selectAll();

    public List<Pit> select(Pit pit);

    @Transactional
    public boolean deleteById(Long id);

    /**
     * 坑洼类别统计
     * @return
     */
    List<PitTypeCountVO> typeCount();

    /**
     * 获取坑洼总数
     * @return
     */
    PitAmountVO countAll();

    /**
     * 处理坑洼数
     * @return
     */
    PitRepairedVO repairedPits();

    /**
     * 当前待处理的坑洼数
     * @return
     */
    PitUnRepairedVO unRepairedCount();

    /**
     * 坑洼分页查询
     * @param pitPageQueryDTO
     * @return
     */
    PageResult pageQuery(PitPageQueryDTO pitPageQueryDTO);
}
