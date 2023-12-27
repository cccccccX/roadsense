package com.roadsense.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * author  Edith
 * created  2023/12/26 19:06
 */
@Data
public class PitPageQueryDTO {
    private Integer pageNum;
    private Integer pageSize;

    private Integer repairStatus;
    private Long pitId;
    private String roadName;
    private BigDecimal degree;
    private String category;
    private String dataSource;
}
