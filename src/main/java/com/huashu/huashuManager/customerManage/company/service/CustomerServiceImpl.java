package com.huashu.huashuManager.customerManage.company.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.huashuManager.common.aop.PageHelperAop;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.mapper.CustomersMapper;
import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomersMapper customersMappermapper;

    @Override
    public int deleteCustomer(String customerId) {
        return customersMappermapper.deleteByPrimaryKey(customerId);
    }

    @Override
    public int addCustomer(Customers customer) {
        return customersMappermapper.insert(customer);
    }

    @Override
    public PageEntity<Customers> pageListCustomers(Customers customer) {
        PageEntity<Customers> entity = new PageEntity<>();
        entity.setPageData(customersMappermapper.selectList(customer));
        return entity;
    }

    @Override
    public List<Customers> listAllCompanyAndID() {
        return customersMappermapper.selectAllCompanyAndId();
    }

    @Override
    public Customers getCustomers(String customerId) {
        return customersMappermapper.selectByPrimaryKey(customerId);
    }

    @Override
    public int updateCustomer(Customers customer) {
        return customersMappermapper.updateByPrimaryKey(customer);
    }

    @Override
    public List<BasicInfo> gitImeiCompany() {
        return customersMappermapper.gitImeiCompany();
    }

    @Override
    public List<BasicInfo> gitCompanyCar(BasicInfo bac) {
        return customersMappermapper.gitCompanyCar(bac);
    }
}
