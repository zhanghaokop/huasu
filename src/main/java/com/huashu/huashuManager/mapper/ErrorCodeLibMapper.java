package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.ErrorCodeLib;
import java.util.List;

public interface ErrorCodeLibMapper {
    int deleteByPrimaryKey(String id);

    int insert(ErrorCodeLib record);

    ErrorCodeLib selectByPrimaryKey(String id);

    List<ErrorCodeLib> selectAll();

    List<ErrorCodeLib> pageSelect(ErrorCodeLib errorCode);

    int updateByPrimaryKey(ErrorCodeLib record);
}