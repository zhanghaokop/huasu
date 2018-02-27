package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.TotalMileAge;
import java.util.List;

public interface TotalMileAgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TotalMileAge record);

    TotalMileAge selectByPrimaryKey(Integer id);

    List<TotalMileAge> selectAll();

    int updateByPrimaryKey(TotalMileAge record);
}