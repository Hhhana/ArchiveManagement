package com.zte.archive.model;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-24 14:14
 * Description:borrow表对应的实体类
 */
public class Borrow implements Serializable {
    private Integer objectId; //主键
    private Integer borrowId;
    private String borrower;
    private Integer loginId;
    private String archiveId;
    private String borrowTime;
    private String endTime;
    private String returnTime;
    private String remark;

    public Borrow() {
    }

    public Borrow(String archiveId, String borrower, Integer borrowId, String borrowTime, String endTime, Integer loginId, Integer objectId, String remark, String returnTime) {
        this.archiveId = archiveId;
        this.borrower = borrower;
        this.borrowId = borrowId;
        this.borrowTime = borrowTime;
        this.endTime = endTime;
        this.loginId = loginId;
        this.objectId = objectId;
        this.remark = remark;
        this.returnTime = returnTime;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
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

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
