package com.huashu.huashuManager.model;

import java.util.Date;

public class Insurance {
    private Integer id;

    private String plateNo;

    private String insuranceNo;

    private String insuranceCompany;

    private String insurancePerson;

    private String insurancePersonTel;

    private String compInsNo;

    private Integer compInsMoney;

    private Date compInsStart;

    private Date compInsEnd;

    private String busiInsNo;

    private Integer busiInsMoney;

    private Date busiInsStart;

    private Date busiInsEnd;

    private Integer total;

    private String album;

    private Integer isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany == null ? null : insuranceCompany.trim();
    }

    public String getInsurancePerson() {
        return insurancePerson;
    }

    public void setInsurancePerson(String insurancePerson) {
        this.insurancePerson = insurancePerson == null ? null : insurancePerson.trim();
    }

    public String getInsurancePersonTel() {
        return insurancePersonTel;
    }

    public void setInsurancePersonTel(String insurancePersonTel) {
        this.insurancePersonTel = insurancePersonTel == null ? null : insurancePersonTel.trim();
    }

    public String getCompInsNo() {
        return compInsNo;
    }

    public void setCompInsNo(String compInsNo) {
        this.compInsNo = compInsNo == null ? null : compInsNo.trim();
    }

    public Integer getCompInsMoney() {
        return compInsMoney;
    }

    public void setCompInsMoney(Integer compInsMoney) {
        this.compInsMoney = compInsMoney;
    }

    public Date getCompInsStart() {
        return compInsStart;
    }

    public void setCompInsStart(Date compInsStart) {
        this.compInsStart = compInsStart;
    }

    public Date getCompInsEnd() {
        return compInsEnd;
    }

    public void setCompInsEnd(Date compInsEnd) {
        this.compInsEnd = compInsEnd;
    }

    public String getBusiInsNo() {
        return busiInsNo;
    }

    public void setBusiInsNo(String busiInsNo) {
        this.busiInsNo = busiInsNo == null ? null : busiInsNo.trim();
    }

    public Integer getBusiInsMoney() {
        return busiInsMoney;
    }

    public void setBusiInsMoney(Integer busiInsMoney) {
        this.busiInsMoney = busiInsMoney;
    }

    public Date getBusiInsStart() {
        return busiInsStart;
    }

    public void setBusiInsStart(Date busiInsStart) {
        this.busiInsStart = busiInsStart;
    }

    public Date getBusiInsEnd() {
        return busiInsEnd;
    }

    public void setBusiInsEnd(Date busiInsEnd) {
        this.busiInsEnd = busiInsEnd;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}