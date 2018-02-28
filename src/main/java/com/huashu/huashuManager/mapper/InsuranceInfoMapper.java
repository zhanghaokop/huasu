package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.InsuranceInfo;
import java.util.List;

public interface InsuranceInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(InsuranceInfo record);

    InsuranceInfo selectByPrimaryKey(String id);

    List<InsuranceInfo> selectAll();

    int updateByPrimaryKey(InsuranceInfo record);
}