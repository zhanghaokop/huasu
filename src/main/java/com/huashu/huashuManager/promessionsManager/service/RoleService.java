package com.huashu.huashuManager.promessionsManager.service;

import com.huashu.huashuManager.model.Role;

import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    void insertRoleMenu(Role role);

    Role selectByPrimaryKey(String id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> selectRoleDetail(Role role);

    List<Role> pageListRole(Role role);
}
