package com.roadsense.vo;

import com.roadsense.dto.RoadPitCountDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * author  Edith
 * created  2023/12/20 11:06
 */
@Data
@Builder
public class RoadPitCountVO {

    private List<String> date;
    private List<RoadPitCountDTO> list;

}