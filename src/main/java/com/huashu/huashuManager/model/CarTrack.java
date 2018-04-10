package com.huashu.huashuManager.model;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: CarTrack.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/24 18:34
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class CarTrack {

    private String id;
    private String lat;
    private String lng;
    private String gpsTime;
    private String trackValue;
    private String createTime;
    private String imei;
    private int totalMile;
    private String beginTime;
    private String endTime;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getTrackValue() {
        return trackValue;
    }

    public void setTrackValue(String trackValue) {
        this.trackValue = trackValue;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getTotalMile() {
        return totalMile;
    }

    public void setTotalMile(int totalMile) {
        this.totalMile = totalMile;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
