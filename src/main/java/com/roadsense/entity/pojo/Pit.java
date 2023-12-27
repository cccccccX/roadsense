package com.roadsense.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
//import lombok.Data;

/**
 * @TableName t_pit
 */
//@Data
@TableName("t_pitinfo")
@Data
public class Pit {
    @TableId
    private Long pitId;

    private Long roadId;

    private String img;

    private String gps;

    private BigDecimal degree;

    private String recRate;

    private String category;

    private String dataSource;

    private String notes;

//    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    private Integer repairStatus;

}