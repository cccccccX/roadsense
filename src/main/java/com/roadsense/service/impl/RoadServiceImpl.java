package com.roadsense.service.impl;

import com.roadsense.mapper.RoadMapper;
import com.roadsense.pojo.Road;
import com.roadsense.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  Edith
 * created  2023/10/30 16:45
 */
@Service
public class RoadServiceImpl implements RoadService {

    @Autowired
    private RoadMapper roadMapper;

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        int i = roadMapper.deleteById(id);
        return i == 1;
    }

    @Override
    @Transactional
    public boolean insert(Road road) {
        int row = roadMapper.insert(road);
        return row == 1;
    }
}
