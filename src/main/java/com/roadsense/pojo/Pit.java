package com.roadsense.pojo;

import java.io.Serializable;
//import lombok.Data;

/**
 * @TableName t_pit
 */
//@Data
public class Pit {
    private Long pitId;

    private Long roadId;

    private String img;

    private String gps;

    private String degree;

    private String recRate;

    private String category;

    private String dataSource;

    private String notes;

    @Override
    public String toString() {
        return "Pit{" +
                "pitId=" + pitId +
                ", roadId=" + roadId +
                ", img='" + img + '\'' +
                ", gps='" + gps + '\'' +
                ", degree='" + degree + '\'' +
                ", recRate='" + recRate + '\'' +
                ", category='" + category + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }

    public Long getRoadId() {
        return roadId;
    }

    public void setRoadId(Long roadId) {
        this.roadId = roadId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRecRate() {
        return recRate;
    }

    public void setRecRate(String recRate) {
        this.recRate = recRate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}