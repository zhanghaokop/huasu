package com.huashu.huashuManager.customer.service;

import com.huashu.huashuManager.mapper.CustomersMapper;
import com.huashu.huashuManager.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomersMapper mapper;

    @Override
    public int deleteCustomer(String customerId) {
        return mapper.deleteByPrimaryKey(customerId);
    }

    @Override
    public int addCustomer(Customers customer) {
        return mapper.insert(customer);
    }

    @Override
    public List<Customers> listCustomers(Customers customer) {
        return mapper.selectList(customer);
    }

    @Override
    public List<Customers> listAllCompanyAndID() {
        return mapper.selectAllCompanyAndId();
    }

    @Override
    public Customers getCustomers(String customerId) {
        return mapper.selectByPrimaryKey(customerId);
    }

    @Override
    public int updateCustomer(Customers customer) {
        return mapper.updateByPrimaryKey(customer);
    }
}
