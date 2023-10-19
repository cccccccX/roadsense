package com.roadsense.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_repair
 */
@Data
public class Repair implements Serializable {
    private Long repairId;

    private Long pitId;

    private String repairState;

    private Long handlerId;

    private Date handleTime;

    private static final long serialVersionUID = 1L;
}