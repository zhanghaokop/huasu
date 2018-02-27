package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Insurance;
import java.util.List;

public interface InsuranceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insurance record);

    Insurance selectByPrimaryKey(Integer id);

    List<Insurance> selectAll();

    int updateByPrimaryKey(Insurance record);
}