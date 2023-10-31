package com.roadsense.service;

import com.roadsense.pojo.Pit;
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

}
