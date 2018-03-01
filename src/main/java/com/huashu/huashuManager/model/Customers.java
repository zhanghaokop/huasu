package com.huashu.huashuManager.model;

/**
 * 客户
 */
public class Customers {

    /**
     * 主键ID,公司ID
     */
    private String id;

    /**
     * 客户公司名称
     */
    private String company;

    private String userId;

    /**
     * 站点名称
     */
    private String abb;

    /**
     * 中文站点名称
     */
    private String cnAbb;

    /**
     * 法人对象
     */
    private String legalPerson;

    /**
     * 微信号
     */
    private String weChat;

    /**
     * 省份
     */
    private String province;

    /**
     * 城镇
     */
    private String town;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 开户行账号
     */
    private String bankAccount;

    /**
     * 电话
     */
    private String tel;

    /**
     * 手机
     */
    private String taxId;

    /**
     * 等级
     */
    private String level;

    /**
     * 总销售额
     */
    private Integer totalSale;

    /**
     * 上年销售额
     */
    private Integer lastSale;

    /**
     *
     */
    private String album;

    /**
     * 备注
     */
    private String rem;

    /**
     * 是否删除
     */
    private String deltag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAbb() {
        return abb;
    }

    public void setAbb(String abb) {
        this.abb = abb == null ? null : abb.trim();
    }

    public String getCnAbb() {
        return cnAbb;
    }

    public void setCnAbb(String cnAbb) {
        this.cnAbb = cnAbb == null ? null : cnAbb.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId == null ? null : taxId.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Integer totalSale) {
        this.totalSale = totalSale;
    }

    public Integer getLastSale() {
        return lastSale;
    }

    public void setLastSale(Integer lastSale) {
        this.lastSale = lastSale;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem == null ? null : rem.trim();
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag == null ? null : deltag.trim();
    }
}