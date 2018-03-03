package com.huashu.huashuManager.model;

import java.util.Date;

/**
 * 驾驶员信息实体类
 */
public class DriverInfo {
    /**
     * 驾驶员ID，主键
     */
    private String id;

    /**
     * 驾驶员姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 车牌号  //TODO 关联
     */
    private String plateNo;

    /**
     * 客户公司名字
     */
    private String company;

    /**
     * 驾照类型
     */
    private String driveType;

    /**
     * 常住地址
     */
    private String address;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 名族
     */
    private String nation;

    /**
     * 是否在职
     */
    private Integer onJob;

    /**
     * 是否删除
     */
    private String deltag;

    /**
     * 所属关联客户公司Id
     */
    private String companyid;

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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType == null ? null : driveType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public Integer getOnJob() {
        return onJob;
    }

    public void setOnJob(Integer onJob) {
        this.onJob = onJob;
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag == null ? null : deltag.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }
}