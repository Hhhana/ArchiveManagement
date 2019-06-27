package com.zte.archive.model;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-24 14:14
 * Description:lose表对应的实体类
 */
public class Lose implements Serializable {
    private Integer objectId;
    private String archiveId;
    private String state;
    private Integer loginId;
    private Integer loserId;
    private String loser;
    private String loseTime;
    private String remark;

    public Lose() {
    }

    public Lose(Integer objectId, String archiveId, String state, Integer loginId, Integer loserId, String loser, String loseTime, String remark) {
        this.objectId = objectId;
        this.archiveId = archiveId;
        this.state = state;
        this.loginId = loginId;
        this.loserId = loserId;
        this.loser = loser;
        this.loseTime = loseTime;
        this.remark = remark;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getLoserId() {
        return loserId;
    }

    public void setLoserId(Integer loserId) {
        this.loserId = loserId;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(String loseTime) {
        this.loseTime = loseTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Lose{" +
                "archiveId='" + archiveId + '\'' +
                ", state='" + state + '\'' +
                ", loginId=" + loginId +
                ", loserId=" + loserId +
                ", loser='" + loser + '\'' +
                ", loseTime='" + loseTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
