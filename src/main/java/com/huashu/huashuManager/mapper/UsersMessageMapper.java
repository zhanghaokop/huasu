package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.UsersMessage;
import java.util.List;

public interface UsersMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UsersMessage record);

    UsersMessage selectByPrimaryKey(Integer id);

    List<UsersMessage> selectAll();

    int updateByPrimaryKey(UsersMessage record);
}