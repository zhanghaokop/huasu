package com.huashu.huashuManager.carManager.controller;

import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.customerManage.company.service.CustomerService;
import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("imei")
public class CarController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("list")
    public ResponseEntity<List<BasicInfo>> gitImeiCompany(){
        return new ResponseEntity.Builder<List<BasicInfo>>().setData(customerService.gitImeiCompany()).build();
    }

    @GetMapping("listOwner")
    public ResponseEntity<List<BasicInfo>> gitCompanyCar(){
        BasicInfo bac =new BasicInfo();
        bac.setCompanyid(SessionStateHolder.getUser().getCompanyId());
        return new ResponseEntity.Builder<List<BasicInfo>>().setData(customerService.gitCompanyCar(bac)).build();
    }

    @GetMapping("gitOwnCar")
    public ResponseEntity<List<BasicInfo>> gitCompanyCar(BasicInfo bac){
        return new ResponseEntity.Builder<List<BasicInfo>>().setData(customerService.gitCompanyCar(bac)).build();
    }

}
