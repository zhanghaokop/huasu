package com.huashu.huashuManager.customerManage.company.controller;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.JIMIAPIService;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.customerManage.company.service.CustomerService;
import com.huashu.huashuManager.model.Customers;
import com.huashu.huashuManager.promessionsManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户管理控制器
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JIMIAPIService api;
    @Resource
    private UserService userService;
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
    public ResponseEntity<PageEntity<Customers>> list(Customers customers){
        return new ResponseEntity.Builder<PageEntity<Customers>>().setData(customerService.pageListCustomers(customers)).build();
    }

    /**
     * 返回全部的公司客户集合 companyId ： companyName
     * @return
     */
    @GetMapping("/listCompany")
    public ResponseEntity<List<Customers>> listAllCustomers(){
        return new ResponseEntity.Builder<List<Customers>>().setData(customerService.listAllCompanyAndID()).build();
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

        //TODO 新增成功后-> 同时生成公司客户的admin
        userService.insertDefaultUser(customers.getLegalPerson(),id);
        return new ResponseEntity.Builder<Boolean>().setData(flag).build();
    }

    /**
     * 删除客户
     * @param customerId
     * @return
     */
    @GetMapping("/delete/{customerId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable String customerId){
        return new ResponseEntity.Builder<Boolean>().setData(customerService.deleteCustomer(customerId) > 0).build();
    }

    /**
     * 更新客户
     * @param customers
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody Customers customers){
        return new ResponseEntity.Builder<Boolean>().setData(customerService.updateCustomer(customers) > 0).build();
    }
}
