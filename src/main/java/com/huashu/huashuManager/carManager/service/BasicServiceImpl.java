package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.BasicInfoMapper;
import com.huashu.huashuManager.model.BasicInfo;
import com.huashu.huashuManager.model.Customers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: BasicServiceImpl.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/3 16:05
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Transactional
@Service
public class BasicServiceImpl implements BasicService{
    @Resource
    private BasicInfoMapper basicInfoMapper;

    @Override
    public void deleteByPrimaryKey(String id) {
       basicInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(BasicInfo record) {
        record.setId(UUIDUtils.getUUID());
        basicInfoMapper.insert(record);
    }

    @Override
    public BasicInfo selectByPrimaryKey(String id) {
        return basicInfoMapper.selectByPrimaryKey(id) ;
    }

    @Override
    public List<BasicInfo> selectAll() {
        return basicInfoMapper.selectAll();
    }

    @Override
    public void updateByPrimaryKey(BasicInfo record) {
        basicInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> getImeiLIst() {
       return basicInfoMapper.getImeiLIst();
    }

    @Override
    public PageEntity<BasicInfo> pageListBasic(BasicInfo basicInfo) {
        PageEntity<BasicInfo> entity = new PageEntity<>();
        basicInfo.setCompanyid(SessionStateHolder.getUser().getCompanyId());
        entity.setPageData(basicInfoMapper.pageListBasic(basicInfo));
        return entity;
    }
}
