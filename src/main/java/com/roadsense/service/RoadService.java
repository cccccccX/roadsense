package com.roadsense.service;

import com.roadsense.pojo.Road;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  Edith
 * created  2023/10/30 16:45
 */
@Transactional
public interface RoadService {

    public boolean deleteById(Long id);

    public boolean insert(Road road);


}
