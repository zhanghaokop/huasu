package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Menu;
import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(String menuid);

    int insert(Menu record);

    Menu selectByPrimaryKey(String menuid);

    List<Menu> selectAll(Menu menu);

    int updateByPrimaryKey(Menu record);
}