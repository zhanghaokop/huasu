package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.BasicInfo;
import java.util.List;

public interface BasicInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(BasicInfo record);

    BasicInfo selectByPrimaryKey(String id);

    List<BasicInfo> selectAll();

    int updateByPrimaryKey(BasicInfo record);
}