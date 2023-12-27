package com.roadsense.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
//import lombok.Data;

/**
 * @TableName t_repair
 */
//@Data
@Data
@TableName("t_repair")
public class Repair{
    @TableId
    private Long repairId;

    private Long pitId;

    private Integer repairState;

    private Long handlerId;

    private LocalDateTime handleTime;


}