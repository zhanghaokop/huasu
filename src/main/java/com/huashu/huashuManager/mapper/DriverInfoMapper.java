package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.DriverInfo;
import java.util.List;

public interface DriverInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DriverInfo record);

    DriverInfo selectByPrimaryKey(String id);

    List<DriverInfo> selectDriver(DriverInfo record);

    List<DriverInfo> pageSelect(DriverInfo record);

    List<DriverInfo> selectAll();

    int updateByPrimaryKey(DriverInfo record);
}