package com.huashu.huashuManager.promessions.service;

import com.huashu.huashuManager.model.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    User select(User user);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectDetail (User user);

    List<User> pageListUser(User user);

    void insertDefaultUser(String name);
}
