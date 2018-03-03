package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.SupplierInfo;
import java.util.List;

public interface SupplierInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplierInfo record);

    SupplierInfo selectByPrimaryKey(String id);

    List<SupplierInfo> selectAll();

    //分页 模糊匹配 条件查询
    List<SupplierInfo> pageSelect(SupplierInfo record);



    int updateByPrimaryKey(SupplierInfo record);
}