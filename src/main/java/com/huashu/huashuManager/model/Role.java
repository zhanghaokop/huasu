package com.huashu.huashuManager.model;

import java.util.List;

public class Role {

    private List<Menu> menus;

    private String id;

    public List<Menu> getMenus() {
        return menus;
    }


    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Role{" +
                "menus=" + menus +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}