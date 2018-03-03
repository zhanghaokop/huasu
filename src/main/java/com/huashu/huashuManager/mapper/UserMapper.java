package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.User;
import com.huashu.huashuManager.model.UserMenu;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    User selectDetail(User user);

    User select(User user);

    List<User> selectAll();

    List<User> pageListUser(User user);

    int updateByPrimaryKey(User record);
}