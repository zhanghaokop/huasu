package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Users;
import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    Users selectByPrimaryKey(Integer id);

    Users select(Users users);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
}