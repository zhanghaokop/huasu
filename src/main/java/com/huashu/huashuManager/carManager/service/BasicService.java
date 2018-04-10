package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.BasicInfo;

import java.util.List;

public interface BasicService {

    void deleteByPrimaryKey(String id);

    void insert(BasicInfo record);

    BasicInfo selectByPrimaryKey(String id);

    List<BasicInfo> selectAll();

    void updateByPrimaryKey(BasicInfo record);

    PageEntity<BasicInfo> pageListBasic(BasicInfo basicInfo);

    List<String> getImeiLIst ();
}
