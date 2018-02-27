package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.RepairStation;
import java.util.List;

public interface RepairStationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepairStation record);

    RepairStation selectByPrimaryKey(Integer id);

    List<RepairStation> selectAll();

    int updateByPrimaryKey(RepairStation record);
}