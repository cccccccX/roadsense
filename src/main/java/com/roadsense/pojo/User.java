package com.roadsense.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName t_user
 */
@Data
public class User implements Serializable {
    private Long userId;

    private String userName;

    private String userPwd;

    private String userTel;

    private Integer isManager;

    private static final long serialVersionUID = 1L;
}