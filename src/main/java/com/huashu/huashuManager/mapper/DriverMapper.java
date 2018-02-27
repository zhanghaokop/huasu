package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Driver;
import java.util.List;

public interface DriverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Driver record);

    Driver selectByPrimaryKey(Integer id);

    List<Driver> selectAll();

    int updateByPrimaryKey(Driver record);
}