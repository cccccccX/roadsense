package com.roadsense.pojo;

import lombok.Data;

import java.io.Serializable;
//import lombok.Data;

/**
 * @TableName t_pit
 */
//@Data
@Data
public class Pit {
    private Long pitId;

    private Long roadId;

    private String img;

    private String gps;

    private String degree;

    private String recRate;

    private String category;

    private String dataSource;

    private String notes;


}