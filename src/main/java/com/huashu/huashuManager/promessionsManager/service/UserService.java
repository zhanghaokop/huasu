package com.huashu.huashuManager.promessionsManager.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    User select(User user);

    List<User> selectAll(User user);

    int updateByPrimaryKey(User record);

    User selectDetail (User user);

    PageEntity<User> pageListUser(User user);

    void insertDefaultUser(String name,String companyId);
}
