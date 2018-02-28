package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    User select(User user);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}