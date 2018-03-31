package com.huashu.huashuManager.promessionsManager.controller;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.model.User;
import com.huashu.huashuManager.promessionsManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: UserController.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/2/28 22:24
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable  String id){
        User user = new User();
        user.setId(id);
        return new ResponseEntity.Builder<User>()
                .setCode(200).setData(userService.selectDetail(user)).build();
    }

    @GetMapping ("getUserList")
    public ResponseEntity<List<User>> getUserList( User user){
        return new ResponseEntity.Builder<List<User>>().setData(userService.selectAll(user)).build();
    }

    /**
     * 用户分页查询
     * @param user
     * @return
     */
    @GetMapping("getUserByPage")
    public ResponseEntity<PageEntity<User>> getUserByPage( User user){
        return new ResponseEntity.Builder<PageEntity<User>>()
                .setCode(200).setData(userService.pageListUser(user)).build();
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody User user){
        userService.deleteByPrimaryKey(user.getId());
        return new ResponseEntity.Builder<String>()
                .setCode(200).setData("success").build();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.updateByPrimaryKey(user);
        return new ResponseEntity.Builder<String>()
                .setCode(200).setData("success").build();
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("insertUser")
    public ResponseEntity<String> insertUser(@RequestBody User user){

        userService.insert(user);
        return new ResponseEntity.Builder<String>()
                .setCode(200).setData("success").build();
    }
}
