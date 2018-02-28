package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.DriverInfo;
import java.util.List;

public interface DriverInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DriverInfo record);

    DriverInfo selectByPrimaryKey(String id);

    List<DriverInfo> selectAll();

    int updateByPrimaryKey(DriverInfo record);
}