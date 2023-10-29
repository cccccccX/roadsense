package com.roadsense.pojo;

import java.io.Serializable;
import java.util.Date;
//import lombok.Data;

/**
 * @TableName t_repair
 */
//@Data
public class Repair{
    private Long repairId;

    private Long pitId;

    private String repairState;

    private Long handlerId;

    private Date handleTime;

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", pitId=" + pitId +
                ", repairState='" + repairState + '\'' +
                ", handlerId=" + handlerId +
                ", handleTime=" + handleTime +
                '}';
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Long handlerId) {
        this.handlerId = handlerId;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}