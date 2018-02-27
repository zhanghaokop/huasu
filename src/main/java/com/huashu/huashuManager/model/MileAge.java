package com.huashu.huashuManager.model;

import java.util.Date;

public class MileAge {
    private Integer id;

    private String imei;

    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMile() {
        return mile;
    }

    public void setMile(Integer mile) {
        this.mile = mile;
    }
}