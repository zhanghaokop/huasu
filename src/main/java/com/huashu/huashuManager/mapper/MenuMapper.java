package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.Menu;
import java.util.List;

public interface MenuMapper {
    /**
     * 删除页面资源
     * @param menuid
     * @return
     */
    int deleteByPrimaryKey(String menuid);

    /**
     * 新增页面资源
     * @param record
     * @return
     */
    int insert(Menu record);

    /**
     * 查询页面资源
     * @param menuid
     * @return
     */
    Menu selectByPrimaryKey(String menuid);

    /**
     * 查询页面资源list
     * @param menu
     * @return
     */
    List<Menu> selectAll(Menu menu);

    /**
     * 更新页面资源
     * @param record
     * @return
     */
    int updateByPrimaryKey(Menu record);
}