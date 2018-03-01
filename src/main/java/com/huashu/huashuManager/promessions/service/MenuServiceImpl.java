package com.huashu.huashuManager.promessions.service;

import com.huashu.huashuManager.mapper.MenuMapper;
import com.huashu.huashuManager.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Menu> getMenuByPage(Menu menu) {
        return menuMapper.selectAll(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public void deleteMenu(String id) {
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertMenu(Menu menu) {
        menuMapper.insert(menu);
    }
}
