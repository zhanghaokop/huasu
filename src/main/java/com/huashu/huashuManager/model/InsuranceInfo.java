package com.huashu.huashuManager.model;

public class InsuranceInfo {
    private String id;

    private String plateNo;

    private String insuranceNo;

    private String insuranceCompany;

    private String insurancePerson;

    private String insurancePersonTel;

    private String compInsNo;

    private Integer compInsMoney;

    private String compInsStart;

    private String compInsEnd;

    private String busiInsNo;

    private Integer busiInsMoney;

    private String busiInsStart;

    private String busiInsEnd;

    private Integer total;

    private String deltag;

    private String companyid;

    private String album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getCompInsStart() {
        return compInsStart;
    }

    public void setCompInsStart(String compInsStart) {
        this.compInsStart = compInsStart;
    }

    public String getCompInsEnd() {
        return compInsEnd;
    }

    public void setCompInsEnd(String compInsEnd) {
        this.compInsEnd = compInsEnd;
    }

    public String getBusiInsStart() {
        return busiInsStart;
    }

    public void setBusiInsStart(String busiInsStart) {
        this.busiInsStart = busiInsStart;
    }

    public String getBusiInsEnd() {
        return busiInsEnd;
    }

    public void setBusiInsEnd(String busiInsEnd) {
        this.busiInsEnd = busiInsEnd;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}