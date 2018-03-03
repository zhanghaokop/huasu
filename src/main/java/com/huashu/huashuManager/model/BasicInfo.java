package com.huashu.huashuManager.model;

import java.util.Date;
import java.util.List;

public class BasicInfo {

    private List<InsuranceInfo> insuranceInfos;
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
     * 车架号
     */
    private String vin;

    /**
     * 发动机号
     */
    private String engineNo;

    /**
     * 车辆类型
     */
    private String vehicle;

    /**
     * 使用性质
     */
    private String useCharacter;

    /**
     * 所属人
     */
    private String owner;

    /**
     * 住址
     */
    private String address;

    /**
     * 品牌型号
     */
    private String model;

    /**
     * 动力类型
     */
    private String powerType;

    /**
     * 注册日期
     */
    private Date regDate;

    /**
     * 发证日期
     */
    private Date issueDate;

    /**
     * 年检到期日
     */
    private Date repairCheckDate;

    /**
     * 软删
     */
    private String deltag;

    /**
     *
     */
    private String imei;

    /**
     * 公司id
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

    public List<InsuranceInfo> getInsuranceInfos() {
        return insuranceInfos;
    }

    public void setInsuranceInfos(List<InsuranceInfo> insuranceInfos) {
        this.insuranceInfos = insuranceInfos;
    }
    @Override
    public String toString() {
        return "BasicInfo{" +
                "insuranceInfos=" + insuranceInfos +
                ", id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", factory='" + factory + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", vin='" + vin + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", useCharacter='" + useCharacter + '\'' +
                ", owner='" + owner + '\'' +
                ", address='" + address + '\'' +
                ", model='" + model + '\'' +
                ", powerType='" + powerType + '\'' +
                ", regDate=" + regDate +
                ", issueDate=" + issueDate +
                ", repairCheckDate=" + repairCheckDate +
                ", deltag='" + deltag + '\'' +
                ", imei='" + imei + '\'' +
                ", companyid='" + companyid + '\'' +
                '}';
    }
}