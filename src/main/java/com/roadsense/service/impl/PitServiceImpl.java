package com.roadsense.service.impl;

import com.roadsense.mapper.PitMapper;
import com.roadsense.pojo.Pit;
import com.roadsense.service.PitService;
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
}
