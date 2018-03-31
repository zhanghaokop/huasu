package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.Customers;
import java.util.List;

public interface CustomersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customers record);

    Customers selectByPrimaryKey(String id);

//    Customers selectCustomer(Customers customers);

    List<Customers> selectAll();

    List<Customers> selectAllCompanyAndId();


    List<Customers> selectList(Customers customer);

    int updateByPrimaryKey(Customers record);

    List<BasicInfo> gitImeiCompany();

    List<BasicInfo> gitCompanyCar (BasicInfo bac);

}