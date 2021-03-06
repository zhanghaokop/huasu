package com.huashu.huashuManager.promessionsManager.service;

import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.UtilConstants;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.UserMapper;
import com.huashu.huashuManager.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: UserServiceImpl.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/1 11:43
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper usermapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return usermapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        record.setId(UUIDUtils.getUUID());
        return usermapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return usermapper.selectByPrimaryKey(id);
    }

    @Override
    public User select(User user) {
        return null;
    }

    @Override
    public List<User> selectAll(User user) {
        user.setCompanyId(SessionStateHolder.getUser().getCompanyId());
        return usermapper.selectAll(user);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return usermapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectDetail(User user) {
        return usermapper.selectDetail(user);
    }

    @Override
    public PageEntity<User> pageListUser(User user) {
        PageEntity<User> page =new PageEntity<User>();
        page.setPageData(usermapper.pageListUser(user));
        return page ;
    }

    @Override
    public void insertDefaultUser(String name,String companyId) {
        User user = new User();
        user.setName(name);
        user.setRoleid(UtilConstants.UserConstants.DEFAULT_FOLRID);
        user.setPassword(UtilConstants.UserConstants.PASSWORD);
        user.setCompanyId(companyId);
        //todo 初始role菜单
        this.insert(user);
    }
}
