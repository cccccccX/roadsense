package com.roadsense.entity.vo;

import com.roadsense.entity.dto.RoadRepairedDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * author  Edith
 * created  2023/12/25 21:19
 */
@Data
@Builder
public class RoadRepairedVO {
    private List<String> date;
    private List<RoadRepairedDTO> list;
}
