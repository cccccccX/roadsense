package com.roadsense.service;

import com.roadsense.entity.pojo.Pit;

import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 9:55
 */
public interface RecognizeService {

    public List<Pit> recognize(Long roadId);

}
