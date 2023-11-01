package com.roadsense.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
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

    private String degree;

    private String recRate;

    private String category;

    private String dataSource;

    private String notes;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

}