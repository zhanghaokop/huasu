package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Role;
import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> selectRoleDetail(Role role);
}