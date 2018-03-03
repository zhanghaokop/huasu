package com.huashu.huashuManager.promessions.controller;

import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.model.Role;
import com.huashu.huashuManager.promessions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: RoleController.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/1 13:35
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 新增角色关联权限资源
     * @param role
     * @return
     */
    @PostMapping("insertRole")
    public ResponseEntity<String> insertRole(@RequestBody Role role){
        try {
            roleService.insert(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity.Builder<String>()
                .setCode(200).setData("success").build();
    }


    /**
     * 修改角色
     * @param role
     */
    @PostMapping("updateRole")
    public ResponseEntity<String> updateRole(@RequestBody Role role){
        try {
            roleService.updateByPrimaryKey(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity.Builder<String>()
                .setCode(200).setData("success").build();
    }

    /**
     * 删除角色同时删除资源（前端需提醒）
     * @return
     */
    @PostMapping("deleteRole")
    public ResponseEntity<String> deleteRole(@RequestBody Role role){
        roleService.deleteByPrimaryKey(role.getId());
        return  new ResponseEntity.Builder<String>()
                .setCode(200).setData("success").build();
    }

    /**
     * 查看角色包含页面资源
     * @param role
     * @return
     */
    @RequestMapping("selectRole")
    public ResponseEntity<List<Role>> selectRole(@RequestBody Role role){
        return  new ResponseEntity.Builder<List<Role>>()
                .setCode(200).setData(roleService.selectRoleDetail(role)).build();
    }

    /**
     * 查看角色分页包含页面资源
     * @param role
     * @return
     */
    @RequestMapping("selectRoleByPage")
    public ResponseEntity<List<Role>> selectRoleByPage(@RequestBody Role role){
        return  new ResponseEntity.Builder<List<Role>>()
                .setCode(200).setData(roleService.selectRoleDetail(role)).build();
    }
}
