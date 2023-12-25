package com.roadsense.vo;

import com.roadsense.dto.RoadHealthyDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * author  Edith
 * created  2023/12/25 20:32
 */
@Data
@Builder
public class RoadHealthyVO {
    private List<String> date;
    private List<RoadHealthyDTO> list;
}
