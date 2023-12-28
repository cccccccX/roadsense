package com.roadsense.entity.dto;

import lombok.Data;

/**
 * author  Edith
 * created  2023/12/28 17:46
 */
@Data
public class UserRegisterDTO {
    private String userName;
    private String userPwd;
    private String userTel;
    private Integer isManager;
}
