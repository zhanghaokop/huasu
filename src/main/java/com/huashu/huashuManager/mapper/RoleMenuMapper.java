package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.RoleMenu;
import java.util.List;

public interface RoleMenuMapper {
    int insert(RoleMenu record);

    List<RoleMenu> selectAll();

    void deleteRoleMenu(String roleId);
}