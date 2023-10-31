package com.roadsense.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
//import lombok.Data;

/**
 * @TableName t_feedback
 */
//@Data
@Data
@TableName("t_feedback")
public class Feedback {
    private Long fbackId;

    private Long userId;

    private String fbackImg;

    private Date fbackTime;

    private String verifyState;

    private Long pitId;

    private String desInfo;


}