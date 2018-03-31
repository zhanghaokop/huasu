package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.RepairStation;
import java.util.List;

public interface RepairStationMapper {
    int deleteByPrimaryKey(String id);

    int insert(RepairStation record);

    RepairStation selectByPrimaryKey(String id);

    List<RepairStation> selectAll();
    List<RepairStation> pageSelect(RepairStation record);

    int updateByPrimaryKey(RepairStation record);
}