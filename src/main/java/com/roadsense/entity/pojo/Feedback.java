package com.roadsense.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
//import lombok.Data;

/**
 * @TableName t_feedback
 */
//@Data
@Data
@TableName("t_feedback")
public class Feedback {
    @TableId
    private Long fbackId;

    private Long userId;

    private Long roadId;

    private String roadName;

    private String fbackImg;

    private LocalDateTime fbackTime;

    private Integer verifyState;

    private Long pitId;

    private String desInfo;


}