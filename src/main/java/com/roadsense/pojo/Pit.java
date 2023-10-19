package com.roadsense.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_pit
 */
@Data
public class Pit implements Serializable {
    private Long pitId;

    private Long roadId;

    private String img;

    private String gps;

    private String degree;

    private String recRate;

    private String category;

    private String dataSource;

    private String notes;

    private static final long serialVersionUID = 1L;
}