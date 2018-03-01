package com.huashu.huashuManager.model;

import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: UserMenu.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/1 11:49
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class UserMenu extends User{
    private List<Menu> Menu ;

    public List<Menu> getMenu() {
        return Menu;
    }

    public void setMenu(List<Menu> menu) {
        Menu = menu;
    }

    @Override
    public String toString() {
        return "UserMenu{" +
                "Menu=" + Menu +
                '}';
    }
}
