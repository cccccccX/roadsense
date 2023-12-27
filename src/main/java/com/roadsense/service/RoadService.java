package com.roadsense.service;

import com.roadsense.entity.pojo.Road;
import com.roadsense.entity.vo.RoadHealthyVO;
import com.roadsense.entity.vo.RoadPitCountVO;
import com.roadsense.entity.vo.RoadRepairedVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  Edith
 * created  2023/10/30 16:45
 */
@Transactional
public interface RoadService {


    public boolean deleteById(Long id);

    public boolean insert(Road road);

    public Road getRoadId(String name);

    /**
     * 各街道坑洼数量统计
     * @return
     */
    RoadPitCountVO pitCount();

    /**
     * 各街道健康指数统计
     * @return
     */
    RoadHealthyVO healthy();

    /**
     * 各街道维护坑洼数量统计
     * @return
     */
    RoadRepairedVO repairedPits();
}
