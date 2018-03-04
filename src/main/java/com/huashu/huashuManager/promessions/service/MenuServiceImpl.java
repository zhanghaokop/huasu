package com.huashu.huashuManager.promessions.service;

import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.MenuMapper;
import com.huashu.huashuManager.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: MenuServiceImpl.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/2/28 22:01
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 获取页面资源list
     * @param menu
     * @return
     */
    @Override
    public List<Menu> getMenuList(Menu menu) {
        return menuMapper.selectAll(menu);
    }

    /**
     * 分页获取页面资源
     * @param menu
     * @return
     */
    @Override
    public List<Menu> pageListMenu(Menu menu) {
        return menuMapper.selectAll(menu);
    }

    /**
     * 更新页面资源
     * @param menu
     */
    @Override
    public void updateMenu(Menu menu) {
//        if(StringUtils.isEmpty(menu.getMenuid());
//            throws new Exception("更新页面资源时id为空");
        menuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 删除页面资源
     * @param id
     */
    @Override
    public void deleteMenu(String id) {
        menuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增页面资源
     * @param menu
     */
    @Override
    public void insertMenu(Menu menu) {
        menu.setMenuid(UUIDUtils.getUUID());
        menuMapper.insert(menu);
    }
}
