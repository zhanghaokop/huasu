package com.huashu.huashuManager.common.bo;

public class PageEntity {

    /**
     * 当前页数
     */
    private int pageIndex = 0;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    public int getPageIndex() {
        return pageIndex;
    }

    public PageEntity setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageEntity setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
