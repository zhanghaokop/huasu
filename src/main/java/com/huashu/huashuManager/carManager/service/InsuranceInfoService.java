package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.model.InsuranceInfo;

import java.util.List;

public interface InsuranceInfoService {

    void deleteByPrimaryKey(String id);

    void insert(InsuranceInfo record);

    InsuranceInfo selectByPrimaryKey(String id);

    List<InsuranceInfo> selectAll(InsuranceInfo insuranceInfo);

    List<InsuranceInfo> pageListInsuranceInfo(InsuranceInfo insuranceInfo);

    void updateByPrimaryKey(InsuranceInfo record);
}
