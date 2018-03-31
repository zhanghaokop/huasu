package com.huashu.huashuManager.customerManage.company.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.Customers;

import java.util.List;

/**
 * 客户管理服务类
 */
public interface CustomerService {

    /**
     * 删除客户
     * @param customerId
     * @return
     */
    int deleteCustomer(String customerId);

    /**
     * 新增客户
     * @param customer
     * @return
     */
    int addCustomer(Customers customer);

    /**
     * 批量查询客户
     * @param customer
     * @return
     */
    PageEntity<Customers> pageListCustomers(Customers customer);

    List<Customers> listAllCompanyAndID();

    Customers getCustomers(String customerId);

    /**
     * 更新客户
     * @param customer
     * @return
     */
    int updateCustomer(Customers customer);

    List<BasicInfo> gitImeiCompany();

    List<BasicInfo> gitCompanyCar (BasicInfo bac);

}
