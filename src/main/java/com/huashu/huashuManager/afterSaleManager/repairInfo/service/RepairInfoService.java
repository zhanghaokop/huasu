package com.huashu.huashuManager.afterSaleManager.repairInfo.service;

import com.huashu.huashuManager.model.RepairInfo;

import java.util.List;

/**
 * 维修信息服务类
 */
public interface RepairInfoService {
    /**
     * 删除维修信息
     * @param repairInfoId
     * @return
     */
    int deleteRepairInfo(String repairInfoId);

    /**
     * 新增维修信息
     * @param repairInfo
     * @return
     */
    int addRepairInfo(RepairInfo repairInfo);

    /**
     * 列表维修信息
     * @param repairInfo
     * @return
     */
    List<RepairInfo> pageListRepairInfo(RepairInfo repairInfo);

    /**
     * 根据维修信息id获取维修信息
     * @param id
     * @return
     */
    RepairInfo getRepairInfoById(String id);

    /**
     * 更新维修信息
     * @param repairInfo
     * @return
     */
    int updateRepairInfo(RepairInfo repairInfo);

}
