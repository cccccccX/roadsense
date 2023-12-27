package com.roadsense.entity.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * author  Edith
 * created  2023/12/25 20:29
 */
@Data
public class RoadHealthyDTO {
    private String roadName;
    private List<BigDecimal> healthyExp;

}
