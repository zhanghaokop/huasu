package com.huashu.huashuManager.afterSaleManager.repairInfo.controller;

import com.huashu.huashuManager.afterSaleManager.repairInfo.service.RepairInfoService;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.model.RepairInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 维修信息控制器
 */
@RestController
@RequestMapping("repairInfo")
public class RepairInfoController {

    @Autowired
    private RepairInfoService repairInfoService;

    /**
     * 分页条件模糊查询维修信息集合
     * @param repairInfo
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<PageEntity<RepairInfo>> pageList(RepairInfo repairInfo){
        return new ResponseEntity.Builder<PageEntity<RepairInfo>>().setData(repairInfoService.pageListRepairInfo(repairInfo)).build();
    }

    /**
     * 根据维修信息Id获取对应维修信息
     * @param repairInfoId
     * @return
     */
    @GetMapping("/{repairInfoId}")
    public ResponseEntity<RepairInfo> getRepairInfoById(@PathVariable("repairInfoId") String repairInfoId){
        return new ResponseEntity.Builder<RepairInfo>().setData(repairInfoService.getRepairInfoById(repairInfoId)).build();
    }

    /**
     * 新增维修信息
     * @param repairInfo
     * @return
     */
    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody RepairInfo repairInfo){
        String id = UUIDUtils.getUUID();
        repairInfo.setId(id);
        repairInfoService.addRepairInfo(repairInfo);
        return new ResponseEntity.Builder<String>().setData(id).build();
    }

    /**
     * 更新维修信息
     * @param repairInfo
     * @return
     */
    @PostMapping("update")
    public ResponseEntity<Boolean> update(@RequestBody RepairInfo repairInfo){
        return new ResponseEntity.Builder<Boolean>().setData(repairInfoService.updateRepairInfo(repairInfo) > 0).build();
    }

    /**
     * 根据维修信息删除维修信息
     * @param repairInfoId
     * @return
     */
    @GetMapping("delete/{repairInfoId}")
    public ResponseEntity<Boolean> delete(@PathVariable("repairInfoId") String repairInfoId){
        return new ResponseEntity.Builder<Boolean>().setData(repairInfoService.deleteRepairInfo(repairInfoId) > 0).build();
    }
}


