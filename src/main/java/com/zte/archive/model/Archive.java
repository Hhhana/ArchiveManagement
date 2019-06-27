package com.zte.archive.model;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-24 14:13
 * Description:Archive表对应的实体类
 */
public class Archive implements Serializable {
    private Integer objectId;
    private String archiveId;
    private String typeId;
    private String title;
    private String location;
    private String createrId;
    private Integer levelId;
    private String createTime;
    private String endTime;
    private String state;

    public Archive() {
    }



    public Archive(String archiveId, String createrId, String createTime, String endTime, Integer levelId, String location, Integer objectId, String state, String title, String typeId) {
        this.archiveId = archiveId;
        this.createrId = createrId;
        this.createTime = createTime;
        this.endTime = endTime;
        this.levelId = levelId;
        this.location = location;
        this.objectId = objectId;
        this.state = state;
        this.title = title;
        this.typeId = typeId;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
