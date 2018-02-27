package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.ErrorCodeLib;
import java.util.List;

public interface ErrorCodeLibMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErrorCodeLib record);

    ErrorCodeLib selectByPrimaryKey(Integer id);

    List<ErrorCodeLib> selectAll();

    int updateByPrimaryKey(ErrorCodeLib record);
}