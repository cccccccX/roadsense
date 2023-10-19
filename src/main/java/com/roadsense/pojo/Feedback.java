package com.roadsense.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_feedback
 */
@Data
public class Feedback implements Serializable {
    private Long fbackId;

    private Long userId;

    private String fbackImg;

    private Date fbackTime;

    private String verifyState;

    private Long pitId;

    private String desInfo;

    private static final long serialVersionUID = 1L;
}