package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.TracePoints;
import java.util.List;

public interface TracePointsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TracePoints record);

    TracePoints selectByPrimaryKey(Integer id);

    List<TracePoints> selectAll();

    int updateByPrimaryKey(TracePoints record);
}