package com.roadsense.pojo;

import lombok.Data;

import java.io.Serializable;
//import lombok.Data;

/**
 * @TableName t_road
 */
//@Data
@Data
public class Road{
    private Long roadId;

    private String roadName;

    private Integer pitAmount;

    private Double healthyExp;

    private String notes;


}