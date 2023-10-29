package com.roadsense.pojo;

import java.io.Serializable;
import java.util.Date;
//import lombok.Data;

/**
 * @TableName t_feedback
 */
//@Data
public class Feedback {
    private Long fbackId;

    private Long userId;

    private String fbackImg;

    private Date fbackTime;

    private String verifyState;

    private Long pitId;

    private String desInfo;

    @Override
    public String toString() {
        return "Feedback{" +
                "fbackId=" + fbackId +
                ", userId=" + userId +
                ", fbackImg='" + fbackImg + '\'' +
                ", fbackTime=" + fbackTime +
                ", verifyState='" + verifyState + '\'' +
                ", pitId=" + pitId +
                ", desInfo='" + desInfo + '\'' +
                '}';
    }

    public Long getFbackId() {
        return fbackId;
    }

    public void setFbackId(Long fbackId) {
        this.fbackId = fbackId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFbackImg() {
        return fbackImg;
    }

    public void setFbackImg(String fbackImg) {
        this.fbackImg = fbackImg;
    }

    public Date getFbackTime() {
        return fbackTime;
    }

    public void setFbackTime(Date fbackTime) {
        this.fbackTime = fbackTime;
    }

    public String getVerifyState() {
        return verifyState;
    }

    public void setVerifyState(String verifyState) {
        this.verifyState = verifyState;
    }

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }

    public String getDesInfo() {
        return desInfo;
    }

    public void setDesInfo(String desInfo) {
        this.desInfo = desInfo;
    }
}