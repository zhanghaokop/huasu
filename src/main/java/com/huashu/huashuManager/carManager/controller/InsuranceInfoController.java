package com.huashu.huashuManager.carManager.controller;

import com.huashu.huashuManager.carManager.service.InsuranceInfoService;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.model.InsuranceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: InsuranceInfoController.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/4 19:13
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
@RequestMapping("InsuranceInfo")
public class InsuranceInfoController {
    @Autowired
    private InsuranceInfoService insuranceInfoService;


    /**
     * 分页获取保险基本信息
     * @param insuranceInfo
     * @return
     */
    @PostMapping("getInsInfoByPage")
    public ResponseEntity<List<InsuranceInfo>> getCarByPage(@RequestBody InsuranceInfo insuranceInfo){
        return new ResponseEntity.Builder<List<InsuranceInfo>>().setData(insuranceInfoService.pageListInsuranceInfo(insuranceInfo)).build();
    }

    /**
     * 获取保险详情
     * @param insInfoId
     * @return
     */
    @GetMapping("{insInfoId}")
    public ResponseEntity<InsuranceInfo> getCar(@PathVariable String insInfoId){
        return new ResponseEntity.Builder<InsuranceInfo>().setData(insuranceInfoService.selectByPrimaryKey(insInfoId)).build();
    }

    /**
     * 删除保险信息
     * @param insInfoId
     * @return
     */
    @GetMapping("deleteCar/{insInfoId}")
    public  ResponseEntity<String> deleteCar (@PathVariable String insInfoId){
        insuranceInfoService.deleteByPrimaryKey(insInfoId);
        return new ResponseEntity.Builder<String>().build();
    }

    /**
     * 新增保险信息
     * @param insuranceInfo
     * @return
     */
    @PostMapping("insertInsInfo")
    public  ResponseEntity<String> insertBasicInfo (@RequestBody InsuranceInfo insuranceInfo){
        insuranceInfoService.insert(insuranceInfo);
        return new ResponseEntity.Builder<String>().build();
    }

    /**
     * 更新保险信息
     * @param insuranceInfo
     * @return
     */
    @PostMapping("updateInsInfo")
    public ResponseEntity<String> updateBasicInfo(@RequestBody InsuranceInfo insuranceInfo){
        insuranceInfoService.updateByPrimaryKey(insuranceInfo);
        return new ResponseEntity.Builder<String>().build();
    }
}
