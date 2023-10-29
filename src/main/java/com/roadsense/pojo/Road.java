package com.roadsense.pojo;

import java.io.Serializable;
//import lombok.Data;

/**
 * @TableName t_road
 */
//@Data
public class Road{
    private Long roadId;

    private String roadName;

    private Integer pitAmount;

    private Double healthyExp;

    private String notes;

    @Override
    public String toString() {
        return "Road{" +
                "roadId=" + roadId +
                ", roadName='" + roadName + '\'' +
                ", pitAmount=" + pitAmount +
                ", healthyExp=" + healthyExp +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Long getRoadId() {
        return roadId;
    }

    public void setRoadId(Long roadId) {
        this.roadId = roadId;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public Integer getPitAmount() {
        return pitAmount;
    }

    public void setPitAmount(Integer pitAmount) {
        this.pitAmount = pitAmount;
    }

    public Double getHealthyExp() {
        return healthyExp;
    }

    public void setHealthyExp(Double healthyExp) {
        this.healthyExp = healthyExp;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}