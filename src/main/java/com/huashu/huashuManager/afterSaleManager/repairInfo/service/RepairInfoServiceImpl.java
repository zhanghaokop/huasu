package com.huashu.huashuManager.afterSaleManager.repairInfo.service;

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
        return mapper.insert(repairInfo);
    }

    @Override
    public List<RepairInfo> pageListRepairInfo(RepairInfo repairInfo) {
        return mapper.pageSelect(repairInfo);
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
