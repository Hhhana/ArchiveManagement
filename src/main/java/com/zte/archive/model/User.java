package com.zte.archive.model;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-24 14:13
 * Description:UserInfo表对应的实体类
 */
public class User implements Serializable {
    private Integer loginId;
    private String loginName;
    private String loginPwd;
    private Integer levelId;
    private Integer powerId;
    private Character sex;

    public User() {
    }

    public User(Integer levelId, Integer loginId, String loginName, String loginPwd, Integer powerId, Character sex) {
        this.levelId = levelId;
        this.loginId = loginId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        powerId = powerId;
        this.sex = sex;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        powerId = powerId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}
