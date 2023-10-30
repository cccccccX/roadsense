package com.roadsense.utils;

/**
 * @author chaochao Xv
 * @version 1.0
 * @date 2023-10-14 21:35
 */
/**
 * 统一返回结果状态信息类
 *
 */
public enum CodeEnum {
    /**
     * 不同公司有不同状态码约定
     */
    SUCCESS(200,"success"),

    FAILED(201,null),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed");



    private Integer code;
    private String message;
    private CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
