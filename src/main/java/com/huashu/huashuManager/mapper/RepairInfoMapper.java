package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.RepairInfo;
import java.util.List;

public interface RepairInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(RepairInfo record);

    RepairInfo selectByPrimaryKey(String id);

    List<RepairInfo> selectAll();

    List<RepairInfo> pageSelect(RepairInfo record);

    int updateByPrimaryKey(RepairInfo record);
}