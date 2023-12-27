package com.roadsense.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
//import lombok.Data;

/**
 * @TableName t_road
 */
//@Data
@Data
public class Road{
    @TableId
    private Long roadId;

    private String roadName;

    private Integer pitAmount;

    private Double healthyExp;

    private String notes;


}