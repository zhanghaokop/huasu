package com.huashu.huashuManager.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 会员信息实体类
 */
public class Member {
    /**
     * 会员主键ID
     */
    private String id;

    /**
     * 会员名称
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 驾照类型
     */
    private String drivingType;

    /**
     * 生日
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birth;

    /**
     * 会员所属公司名称
     */
    private String company;

    /**
     * 常住地址
     */
    private String address;


    private String album;

    /**
     * 微信openId？
     */
    private String openId;

    /**
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date submitTime;

    /**
     * 权限等级
     */
    private String level;

    /**
     * 积分
     */
    private Integer score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDrivingType() {
        return drivingType;
    }

    public void setDrivingType(String drivingType) {
        this.drivingType = drivingType == null ? null : drivingType.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}