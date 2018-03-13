package com.huashu.huashuManager.common.bo;

import java.util.List;

public class PageEntity<T> {



    /**
     * 当前页数
     */

    private int pageIndex = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    private List<T> pageData;

    private Long count;

    public Object getPageData() {
        return pageData;
    }

    public PageEntity setPageData(List<T> pageData) {
        this.pageData = pageData;
        return this;
    }

    public Long getCount() {
        return count;
    }

    public PageEntity setCount(Long count) {
        this.count = count;
        return this;
    }

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
