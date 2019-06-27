package com.zte.archive.model;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-24 14:13
 * Description:find表对应的实体类
 */
public class Find implements Serializable{
    private Integer objectId;
    private Integer loginId;
    private String archiveId;
    private Integer findId;
    private String finder;
    private String findTime;
    private String remark;


    public Find() {
    }

    public Find(String archiveId, String finder, Integer findId, String findTime, Integer loginId, Integer objectId, String remark) {
        this.archiveId = archiveId;
        this.finder = finder;
        this.findId = findId;
        this.findTime = findTime;
        this.loginId = loginId;
        this.objectId = objectId;
        this.remark = remark;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getFinder() {
        return finder;
    }

    public void setFinder(String finder) {
        this.finder = finder;
    }

    public Integer getFindId() {
        return findId;
    }

    public void setFindId(Integer findId) {
        this.findId = findId;
    }

    public String getFindTime() {
        return findTime;
    }

    public void setFindTime(String findTime) {
        this.findTime = findTime;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Find{" +
                "loginId=" + loginId +
                ", archiveId='" + archiveId + '\'' +
                ", findId=" + findId +
                ", finder='" + finder + '\'' +
                ", findTime='" + findTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
