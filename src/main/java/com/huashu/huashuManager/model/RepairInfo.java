package com.huashu.huashuManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 维修信息
 */
public class RepairInfo {

    /**
     * 维修信息主键Id
     */
    private String id;

    /**
     * 维修单号
     */
    private String repairNo;

    /**
     *
     */
    private String openId;

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     * 提交公司名称
     */
    private String subCompany;

    /**
     * 故障代码
     */
    private String errorCode;

    /**
     * 故障描述
     */
    private String description;

    /**
     * 提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date submitTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 坐标值
     */
    private String lng;

    /**
     * 坐标值
     */
    private String lat;

    /**
     * 是否删除
     */
    private Integer isdel;

    /**
     * 指定维修点
     */
    private String assignstation;

    /**
     * 实际维修点
     */
    private String actualstation;

    /**
     * 开始维修时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date repairStartTime;

    /**
     * 维修结论
     */
    private String repairSolution;

    /**
     * 维修结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date repairEndTime;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 评价
     */
    private String evaluate;

    /**
     * 维修单完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date finishTime;
    /**
     * 是否完成
     */
    private Integer finished;

    /**
     * 照片
     */
    private String album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo == null ? null : repairNo.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getSubCompany() {
        return subCompany;
    }

    public void setSubCompany(String subCompany) {
        this.subCompany = subCompany == null ? null : subCompany.trim();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getAssignstation() {
        return assignstation;
    }

    public void setAssignstation(String assignstation) {
        this.assignstation = assignstation == null ? null : assignstation.trim();
    }

    public String getActualstation() {
        return actualstation;
    }

    public void setActualstation(String actualstation) {
        this.actualstation = actualstation == null ? null : actualstation.trim();
    }

    public Date getRepairStartTime() {
        return repairStartTime;
    }

    public void setRepairStartTime(Date repairStartTime) {
        this.repairStartTime = repairStartTime;
    }

    public String getRepairSolution() {
        return repairSolution;
    }

    public void setRepairSolution(String repairSolution) {
        this.repairSolution = repairSolution == null ? null : repairSolution.trim();
    }

    public Date getRepairEndTime() {
        return repairEndTime;
    }

    public void setRepairEndTime(Date repairEndTime) {
        this.repairEndTime = repairEndTime;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }
}