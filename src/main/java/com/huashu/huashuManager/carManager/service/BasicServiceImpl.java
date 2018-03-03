package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.mapper.BasicInfoMapper;
import com.huashu.huashuManager.model.BasicInfo;
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
    public List<BasicInfo> pageListBasic(BasicInfo basicInfo) {
        return basicInfoMapper.pageListBasic(basicInfo);
    }
}
