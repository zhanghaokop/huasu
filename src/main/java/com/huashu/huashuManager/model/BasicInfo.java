package com.huashu.huashuManager.model;

import java.util.Date;

public class BasicInfo {
    /**
     * 主键id
     */
    private String id;

    /**
     * 客户名字所属公司
     */
    private String customer;

    /**
     * 厂家
     */
    private String factory;

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     *
     */
    private String vin;

    /**
     *
     */
    private String engineNo;

    /**
     *
     */
    private String vehicle;

    /**
     *
     */
    private String useCharacter;

    /**
     *
     */
    private String owner;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private String model;

    /**
     *
     */
    private String powerType;

    /**
     *
     */
    private Date regDate;

    /**
     *
     */
    private Date issueDate;

    /**
     *
     */
    private Date repairCheckDate;

    /**
     *
     */
    private String deltag;

    /**
     *
     */
    private String imei;

    /**
     *
     */
    private String companyid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo == null ? null : engineNo.trim();
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public String getUseCharacter() {
        return useCharacter;
    }

    public void setUseCharacter(String useCharacter) {
        this.useCharacter = useCharacter == null ? null : useCharacter.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType == null ? null : powerType.trim();
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getRepairCheckDate() {
        return repairCheckDate;
    }

    public void setRepairCheckDate(Date repairCheckDate) {
        this.repairCheckDate = repairCheckDate;
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag == null ? null : deltag.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }
}