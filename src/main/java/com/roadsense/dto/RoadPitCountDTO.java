package com.roadsense.dto;

import lombok.Data;

import java.util.List;

/**
 * author  Edith
 * created  2023/12/20 11:08
 */
@Data
public class RoadPitCountDTO {
    private String roadName;
    private List<Integer> pitCount;
}
