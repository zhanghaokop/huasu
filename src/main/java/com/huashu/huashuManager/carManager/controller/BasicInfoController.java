package com.huashu.huashuManager.carManager.controller;

import com.huashu.huashuManager.carManager.service.BasicService;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.Customers;
import com.huashu.huashuManager.model.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: BasicInfoController.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/3 16:01
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
@RequestMapping("car")
public class BasicInfoController {

    @Autowired
    private BasicService basicService;

    /**
     * 分页获取汽车基本信息
     * @param basicInfo
     * @return
     */
    @PostMapping("getCarByPage")
    public ResponseEntity<PageEntity<BasicInfo>> getCarByPage(@RequestBody BasicInfo basicInfo){
        return new ResponseEntity.Builder<PageEntity<BasicInfo>>().setData(basicService.pageListBasic(basicInfo)).build();
    }

    /**
     * 获取车辆详情
     * @param basicInfoId
     * @return
     */
    @GetMapping("getCar/{basicInfoId}")
        public ResponseEntity<BasicInfo> getCar(@PathVariable String basicInfoId){
        return new ResponseEntity.Builder<BasicInfo>().setData(basicService.selectByPrimaryKey(basicInfoId)).build();
    }

    /**
     * 删除车辆信息
     * @param basicInfoId
     * @return
     */
    @GetMapping("deleteCar/{basicInfoId}")
    public  ResponseEntity<String> deleteCar (@PathVariable String basicInfoId){
        basicService.deleteByPrimaryKey(basicInfoId);
        return new ResponseEntity.Builder<String>().build();
    }

    /**
     * 新增车辆信息
     * @param basicInfo
     * @return
     */
    @PostMapping("insertBasicInfo")
    public  ResponseEntity<String> insertBasicInfo (@RequestBody BasicInfo basicInfo){
        basicService.insert(basicInfo);
        return new ResponseEntity.Builder<String>().build();
    }

    /**
     * 更新车辆信息
     * @param basicInfo
     * @return
     */
    @PostMapping("updateBasicInfo")
    public ResponseEntity<String> updateBasicInfo(@RequestBody BasicInfo basicInfo){
        basicService.updateByPrimaryKey(basicInfo);
        return new ResponseEntity.Builder<String>().build();
    }
}
