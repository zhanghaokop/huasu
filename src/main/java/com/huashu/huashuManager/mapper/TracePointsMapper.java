package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.TracePoints;
import java.util.List;

public interface TracePointsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TracePoints record);

    TracePoints selectByPrimaryKey(String id);

    List<TracePoints> selectAll();

    int updateByPrimaryKey(TracePoints record);
}