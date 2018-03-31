package com.huashu.huashuManager.afterSaleManager.repairStation.controller;

import com.huashu.huashuManager.afterSaleManager.repairStation.service.RepairStationService;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.model.RepairStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 维修站点控制器
 */
@RestController
@RequestMapping("repairStation")
public class RepairStationController {

    @Autowired
    private RepairStationService repairStationService;

    @PostMapping("add")
    public ResponseEntity<String> insert(@RequestBody RepairStation station){
        String id = UUIDUtils.getUUID();
        station.setId(id);
        repairStationService.addRepairStation(station);
        return new ResponseEntity.Builder<String>().setData(id).build();
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> update(@RequestBody RepairStation station){
        return new ResponseEntity.Builder<Boolean>().setData(repairStationService.update(station) > 0).build();
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity.Builder<Boolean>().setData(repairStationService.delete(id) > 0).build();
    }

    /**
     * 获取最近的维修站点的信息
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<PageEntity<RepairStation>> list(RepairStation station){
        return new ResponseEntity.Builder<PageEntity<RepairStation>>().setData(repairStationService.pageListStation(station)).build();
    }

    /**
     * 获取最近的维修站点的信息
     * @return
     */
    @GetMapping("listNearby")
    public ResponseEntity<List<RepairStation>> listNearby(RepairStation station){
        return new ResponseEntity.Builder<List<RepairStation>>().setData(repairStationService.getNearBy(station)).build();
    }

}
