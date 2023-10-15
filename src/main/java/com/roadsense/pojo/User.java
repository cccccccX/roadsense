package com.roadsense.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @TableName user
 */
@Data
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String nickname;

    private String userTel;

    private static final long serialVersionUID = 1L;
}