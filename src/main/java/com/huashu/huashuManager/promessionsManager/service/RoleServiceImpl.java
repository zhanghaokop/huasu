package com.huashu.huashuManager.promessionsManager.service;

import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.RoleMapper;
import com.huashu.huashuManager.mapper.RoleMenuMapper;
import com.huashu.huashuManager.model.Menu;
import com.huashu.huashuManager.model.Role;
import com.huashu.huashuManager.model.RoleMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: RoleServiceImpl.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/1 13:36
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;

    /**
     * 删除角色
     * @param id
     * @return
     */
    @Transactional
    @Override
    public int deleteByPrimaryKey(String id) {
        roleMapper.deleteByPrimaryKey(id);
        roleMenuMapper.deleteRoleMenu(id);
        return 0;
    }

    /**
     * 新增角色
     * @param record
     * @return
     */
    @Transactional
    @Override
    public int insert(Role record) {
        String roleId=UUIDUtils.getUUID();
        record.setId(roleId);
        roleMapper.insert(record);
        if(!CollectionUtils.isEmpty(record.getMenus())){
            RoleMenu roleMenu = new RoleMenu();
            for(Menu menu : record.getMenus()){
                roleMenu.setRoleid(roleId);
                roleMenu.setMenuid(menu.getMenuid());
                roleMenuMapper.insert(roleMenu);
            }
        }
        return 0;
    }

    @Override
    public void insertRoleMenu(Role role) {

    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    /**
     * 修改角色（包括他的权限）
     * @param record
     * @return
     */
    @Transactional
    @Override
    public int updateByPrimaryKey(Role record) {
        roleMapper.updateByPrimaryKey(record);
        if(record.getMenus()!=null){
            roleMenuMapper.deleteRoleMenu(record.getId());
            RoleMenu roleMenu = new RoleMenu();
            for(Menu menu : record.getMenus()){
                roleMenu.setMenuid(menu.getMenuid());
                roleMenu.setRoleid(record.getId());
                roleMenuMapper.insert(roleMenu);
            }
        }
        return 0;
    }

    @Override
    public List<Role> selectRoleDetail(Role role) {
        return roleMapper.selectRoleDetail(role);
    }

    @Override
    public List<Role> pageListRole(Role role) {
        return roleMapper.selectRoleDetail(role);
    }
}
