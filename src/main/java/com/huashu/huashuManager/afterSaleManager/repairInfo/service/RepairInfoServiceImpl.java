package com.huashu.huashuManager.afterSaleManager.repairInfo.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.common.utils.UUIDUtils;
import com.huashu.huashuManager.mapper.RepairInfoMapper;
import com.huashu.huashuManager.model.RepairInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RepairInfoServiceImpl implements RepairInfoService {

    @Autowired
    private RepairInfoMapper mapper;

    @Override
    public int deleteRepairInfo(String repairInfoId) {
        return mapper.deleteByPrimaryKey(repairInfoId);
    }

    @Override
    public int addRepairInfo(RepairInfo repairInfo) {
        repairInfo.setId(UUIDUtils.getUUID());
        return mapper.insert(repairInfo);
    }

    @Override
    public PageEntity<RepairInfo> pageListRepairInfo(RepairInfo repairInfo) {
        PageEntity<RepairInfo> entity = new PageEntity<>();
        entity.setPageData(mapper.pageSelect(repairInfo));
        return entity;
    }

    @Override
    public RepairInfo getRepairInfoById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateRepairInfo(RepairInfo repairInfo) {
        return mapper.updateByPrimaryKey(repairInfo);
    }
}
