package com.roadsense.pojo;

//import java.io.Serializable;
//import lombok.Data;

import lombok.Data;

/**
 * @TableName t_user
 */
@Data
public class User {
    private Long userId;

    private String userName;

    private String userPwd;

    private String userTel;

    private Integer isManager;

}