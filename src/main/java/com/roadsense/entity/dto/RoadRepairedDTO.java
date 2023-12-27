package com.roadsense.entity.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

/**
 * author  Edith
 * created  2023/12/25 21:20
 */
@Data
public class RoadRepairedDTO {
    private String roadName;
    private List<Integer> repairCount;
}
