package com.roadsense.service;

import com.roadsense.pojo.Road;
import com.roadsense.vo.RoadHealthyVO;
import com.roadsense.vo.RoadPitCountVO;
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
}
