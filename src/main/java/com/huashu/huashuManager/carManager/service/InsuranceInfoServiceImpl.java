package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.InsuranceInfoMapper;
import com.huashu.huashuManager.model.InsuranceInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: InsuranceInfoServiceImpl.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/4 19:08
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Service
public class InsuranceInfoServiceImpl implements InsuranceInfoService {

    @Resource
    private InsuranceInfoMapper insuranceInfoMapper;
    @Override
    public void deleteByPrimaryKey(String id) {
        insuranceInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(InsuranceInfo record) {
        record.setId(UUIDUtils.getUUID());
        insuranceInfoMapper.insert(record);
    }

    @Override
    public InsuranceInfo selectByPrimaryKey(String id) {
        return insuranceInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<InsuranceInfo> selectAll(InsuranceInfo insuranceInfo) {
        return insuranceInfoMapper.selectAll(insuranceInfo);
    }

    @Override
    public List<InsuranceInfo> pageListInsuranceInfo(InsuranceInfo insuranceInfo) {
        return insuranceInfoMapper.selectAll(insuranceInfo);
    }

    @Override
    public void updateByPrimaryKey(InsuranceInfo record) {
        insuranceInfoMapper.updateByPrimaryKey(record);
    }
}
