package com.roadsense.pojo;

//import java.io.Serializable;
//import lombok.Data;

/**
 * @TableName t_user
 */
//@Data
public class User {
    private Long userId;

    private String userName;

    private String userPwd;

    private String userTel;

    private Integer isManager;


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userTel='" + userTel + '\'' +
                ", isManager=" + isManager +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getIsManager() {
        return isManager;
    }

    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
    }
}