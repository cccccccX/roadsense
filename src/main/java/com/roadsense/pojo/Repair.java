package com.roadsense.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//import lombok.Data;

/**
 * @TableName t_repair
 */
//@Data
@Data
public class Repair{
    private Long repairId;

    private Long pitId;

    private String repairState;

    private Long handlerId;

    private Date handleTime;


}