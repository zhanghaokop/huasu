package com.huashu.huashuManager.customerManage.company.controller;

import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.customerManage.company.service.CustomerService;
import com.huashu.huashuManager.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户管理控制器
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customers> getById(@PathVariable String customerId){
        return new ResponseEntity.Builder<Customers>().setData(customerService.getCustomers(customerId)).build();
    }

    /**
     * 分页批量查询客户
     * @param customers
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Customers>> list(Customers customers){
        return new ResponseEntity.Builder<List<Customers>>().setData(customerService.pageListCustomers(customers)).setCode(200).build();
    }

    @GetMapping("/listCompany")
    public ResponseEntity<List<Customers>> listAllCustomers(){
        return new ResponseEntity.Builder<List<Customers>>().setData(customerService.listAllCompanyAndID()).setCode(200).build();
    }
    /**
     * 新增客户
     * @param customers
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Boolean> addCustomer(@RequestBody Customers customers){
        String id = UUIDUtils.getUUID();
        customers.setId(id);
        boolean flag = customerService.addCustomer(customers) > 0;
        return new ResponseEntity.Builder<Boolean>().setCode(200).setData(flag).build();
    }

    /**
     * 删除客户
     * @param customerId
     * @return
     */
    @GetMapping("/delete/{customerId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable String customerId){
        return new ResponseEntity.Builder<Boolean>().setData(customerService.deleteCustomer(customerId) > 0).setCode(200).build();
    }

    /**
     * 更新客户
     * @param customers
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody Customers customers){
        return new ResponseEntity.Builder<Boolean>().setData(customerService.updateCustomer(customers) > 0).setCode(200).build();
    }
}
