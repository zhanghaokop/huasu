package com.huashu.huashuManager.customerManage.driver.controller;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.customerManage.driver.service.DriverService;
import com.huashu.huashuManager.model.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    /**
     * 分页查询驾驶员列表
     * @param driverInfo
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<DriverInfo>> pageSelect(DriverInfo driverInfo, PageEntity pageEntity){
        return new ResponseEntity.Builder<List<DriverInfo>>().setData(driverService.pageListDrivers(driverInfo)).setCode(200).build();
    }

    /**
     * 根据驾驶员Id查询驾驶员
     * @param driverId
     * @return
     */
    @GetMapping("/{driverId}")
    public ResponseEntity<DriverInfo> getDriverById(@PathVariable String driverId){
        return new ResponseEntity.Builder<DriverInfo>().setData(driverService.getDriverById(driverId)).build();
    }

    /**
     * 根据条件模糊查询驾驶员
     * @param driverInfo
     * @return
     */
    @GetMapping("/likeQuery")
    public ResponseEntity<List<DriverInfo>> getDriverByLike(DriverInfo driverInfo){
        return new ResponseEntity.Builder<List<DriverInfo>>().setData(driverService.getDriver(driverInfo)).build();
    }

    /**
     * 根据驾驶员ID删除驾驶员
     * @param driverId
     * @return
     */
    @GetMapping("/delete/{driverId}")
    public ResponseEntity<Boolean> deleteDriverById(@PathVariable String driverId){
        return new ResponseEntity.Builder<Boolean>().setData(driverService.deleteDriver(driverId) > 0).build();
    }



    /**
     * 更新驾驶员
     * @param driverInfo
     * @return
     */
    @PostMapping("update")
    public ResponseEntity<Boolean> update(@RequestBody DriverInfo driverInfo){
        return new ResponseEntity.Builder<Boolean>().setData(driverService.updateDriver(driverInfo) > 0).build();
    }

    /**
     * 新增驾驶员
     * @param driverInfo
     * @return
     */
    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody DriverInfo driverInfo){
        String id = UUIDUtils.getUUID();
        driverInfo.setId(id);

        driverService.addDriver(driverInfo);

        return new ResponseEntity.Builder<String>().setData(id).build();
    }
}
