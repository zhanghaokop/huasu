package com.huashu.huashuManager.model;

public class TotalMileAge {
    private Integer id;

    private String imei;

    private Integer mile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Integer getMile() {
        return mile;
    }

    public void setMile(Integer mile) {
        this.mile = mile;
    }
}