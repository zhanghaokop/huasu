package com.huashu.huashuManager.promessions.controller;

import com.huashu.huashuManager.common.bo.ResponseEntity;
import com.huashu.huashuManager.model.Menu;
import com.huashu.huashuManager.promessions.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统名称: huasu
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: MenuController.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/2/28 22:25
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

@RestController
@RequestMapping("menu")
//@Api(value = "UserInfo", description = "菜单资源信息 ")
public class MenuController {

    @Autowired
    private MenuService menuService;


    /**
     * 获取资源
     * @param menu
     * @return
     */
    @PostMapping("getMenu")
    public ResponseEntity<List<Menu>> getMenu(@RequestBody Menu menu){
        return new ResponseEntity.Builder<List<Menu>>()
                .setCode(200).setData(menuService.getMenuList(menu)).build();
    }

    /**
     * 获取资源分页
     * @param menu
     * @return
     */
    @PostMapping("getMenuByPage")
    public ResponseEntity<List<Menu>> getMenuByPage(@RequestBody Menu menu){
        return new ResponseEntity.Builder<List<Menu>>()
                .setCode(200).setData(menuService.pageListMenu(menu)).build();
    }

    /**
     * 更新资源
     * @param menu
     * @return
     */
    @PostMapping("updateMenu")
    public ResponseEntity<String> updateMenu(@RequestBody Menu menu){
        try {
            menuService.updateMenu(menu);
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData("success").build();
        }catch(Exception e){
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData("fail").build();
        }

    }

    /**
     * 新增资源
     * @param menu
     * @return
     */
    @PostMapping("insertMenu")
    public ResponseEntity<String> insertMenu(@RequestBody Menu menu){
        try {
            menuService.insertMenu(menu);
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData("success").build();
        }catch (Exception e){
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData("fail").build();
        }
    }

    /**
     * 删除资源
     * @param id
     * @return
     */
    @PostMapping("deleteMenu")
    public ResponseEntity<String> deleteMenu(@RequestBody String id){
        try {
            menuService.deleteMenu(id);
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData("success").build();
        }catch (Exception e){
            return new ResponseEntity.Builder<String>()
                    .setCode(200).setData("fail").build();
        }
    }
}
