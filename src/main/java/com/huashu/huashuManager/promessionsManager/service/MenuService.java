package com.huashu.huashuManager.promessionsManager.service;

import com.huashu.huashuManager.model.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList(Menu menu);

    List<Menu> pageListMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(String id);

    void insertMenu(Menu menu);
}
