package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Customers;
import java.util.List;

public interface CustomersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customers record);

    Customers selectByPrimaryKey(String id);

    List<Customers> selectAll();

    int updateByPrimaryKey(Customers record);
}