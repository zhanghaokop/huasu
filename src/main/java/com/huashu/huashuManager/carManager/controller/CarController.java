package com.huashu.huashuManager.carManager.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.carManager.service.CatTrackService;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.JIMIAPI;
import com.huashu.huashuManager.common.utils.JIMIAPIService;
import com.huashu.huashuManager.customerManage.company.service.CustomerService;
import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.CarTrack;
import com.huashu.huashuManager.model.Customers;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("imei")
public class CarController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JIMIAPIService jimiapi;

    @Autowired
    private CatTrackService catTrackService;

    /**
     * 全部车辆imei
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<BasicInfo>> gitImeiCompany(){
        return new ResponseEntity.Builder<List<BasicInfo>>().setData(customerService.gitImeiCompany()).build();
    }

    /**
     * 当前登入的imei
     * @return
     */
    @GetMapping("listOwner")
    public ResponseEntity<List<BasicInfo>> gitCompanyCar(){
        BasicInfo bac =new BasicInfo();
        bac.setCompanyid(SessionStateHolder.getUser().getCompanyId());
        return new ResponseEntity.Builder<List<BasicInfo>>().setData(customerService.gitCompanyCar(bac)).build();
    }

    /**
     * 指定companyid的imei
     * @param bac
     * @return
     */
    @GetMapping("gitOwnCar")
    public ResponseEntity<List<BasicInfo>> gitCompanyCar(BasicInfo bac){
        return new ResponseEntity.Builder<List<BasicInfo>>().setData(customerService.gitCompanyCar(bac)).build();
    }

    @GetMapping("{imei}")
    public ResponseEntity<JSONObject> getGps(@PathVariable String imei){
        return new ResponseEntity.Builder<JSONObject>().setData(jimiapi.getGps(imei)).build();
    }

    /**
     * 数据裤取整体
     * @param carTrack
     * @return
     */
    @GetMapping("getImeiTrack")
    public ResponseEntity<JSONArray> getCarTrack(CarTrack carTrack){
        return new ResponseEntity.Builder<JSONArray>().setData(catTrackService.selectByTrackTime(carTrack)).build();
    }

    /**
     * 调用几米实时取
     * @param carTrack
     * @return
     */
    @GetMapping("getImeiTrackByTime")
    public ResponseEntity<JSONObject> getImeiTrackByTime(CarTrack carTrack){
        return new ResponseEntity.Builder<JSONObject>().setData(catTrackService.getImeiTrackByTime(carTrack)).build();
    }

}
