package com.huashu.huashuManager.model;

/**
 * 故障代码实体类
 */
public class ErrorCodeLib {

    /**
     * 故障代码主键ID
     */
    private String id;

    /**
     * 图标编码
     */
    private String album;

    /**
     * 故障编码
     */
    private String code;

    /**
     * 错误代码（具体错误信息）
     */
    private String errorCode;

    /**
     * 适用车型
     */
    private String type;

    /**
     * 是否删除
     */
    private String deltag;

    /**
     * 故障分析
     */
    private String analysis;

    /**
     * 解决方案
     */
    private String plan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album == null ? null : album.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDeltag() {
        return deltag;
    }

    public void setDeltag(String deltag) {
        this.deltag = deltag == null ? null : deltag.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan == null ? null : plan.trim();
    }
}