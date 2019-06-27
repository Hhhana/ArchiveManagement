package com.zte.archive.model;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-24 14:14
 * Description:destroy表对应的实体类
 */
public class Destroy implements Serializable {
    private Integer objectId;
    private Integer loginId;
    private String archiveId;
    private String destroyTime;
    private String remark;

    public Destroy() {
    }

    public Destroy(Integer objectId, Integer loginId, String archiveId, String destroyTime, String remark) {
        this.objectId = objectId;
        this.loginId = loginId;
        this.archiveId = archiveId;
        this.destroyTime = destroyTime;
        this.remark = remark;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(String destroyTime) {
        this.destroyTime = destroyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Destroy{" +
                "loginId='" + loginId + '\'' +
                ", archiveId='" + archiveId + '\'' +
                ", destroyTime='" + destroyTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

}
