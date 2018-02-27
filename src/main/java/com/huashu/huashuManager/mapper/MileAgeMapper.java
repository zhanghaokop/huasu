package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.MileAge;
import java.util.List;

public interface MileAgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MileAge record);

    MileAge selectByPrimaryKey(Integer id);

    List<MileAge> selectAll();

    int updateByPrimaryKey(MileAge record);
}