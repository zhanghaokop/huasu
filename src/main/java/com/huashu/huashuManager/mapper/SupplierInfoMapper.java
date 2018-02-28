package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.SupplierInfo;
import java.util.List;

public interface SupplierInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplierInfo record);

    SupplierInfo selectByPrimaryKey(String id);

    List<SupplierInfo> selectAll();

    int updateByPrimaryKey(SupplierInfo record);
}