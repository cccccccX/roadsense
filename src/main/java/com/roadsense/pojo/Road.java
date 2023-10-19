package com.roadsense.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_road
 */
@Data
public class Road implements Serializable {
    private Long roadId;

    private String roadName;

    private Integer pitAmount;

    private Double healthyExp;

    private String notes;

    private static final long serialVersionUID = 1L;
}