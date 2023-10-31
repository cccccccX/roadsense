package com.roadsense.service.impl;

import com.roadsense.pojo.Pit;
import com.roadsense.service.RecognizeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author  Edith
 * created  2023/10/31 9:56
 */
@Service
public class RecognizeServiceImpl implements RecognizeService {

    /**
     * 识别坑洼
     * 从原始数据表中获取数据，通过分析后封装成Pit类列表返回,带有了roadName
     * @return Pit类列表
     */
    @Override
    public List<Pit> recognize(Long roadId) {
        Pit pit = new Pit();
        pit.setNotes("这是一个测试识别坑洼");
        pit.setRoadId(roadId);
        List<Pit> pits = new ArrayList<>();
        pits.add(pit);
        return pits;
    }
}
