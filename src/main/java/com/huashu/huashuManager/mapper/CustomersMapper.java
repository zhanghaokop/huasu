package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Customers;
import java.util.List;

public interface CustomersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customers record);

    Customers selectByPrimaryKey(Integer id);

    List<Customers> selectAll();

    int updateByPrimaryKey(Customers record);
}