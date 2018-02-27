package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.RepairNo;
import java.util.List;

public interface RepairNoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepairNo record);

    RepairNo selectByPrimaryKey(Integer id);

    List<RepairNo> selectAll();

    int updateByPrimaryKey(RepairNo record);
}