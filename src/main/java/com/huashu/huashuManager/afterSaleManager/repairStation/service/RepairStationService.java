package com.huashu.huashuManager.afterSaleManager.repairStation.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.RepairStation;

import java.util.List;

public interface RepairStationService {

    int addRepairStation(RepairStation station);

    int update(RepairStation station);

    int delete(String id);

    List<RepairStation> getAll();

    PageEntity<RepairStation> pageListStation(RepairStation station);

    List<RepairStation> getNearBy(RepairStation station);
}
