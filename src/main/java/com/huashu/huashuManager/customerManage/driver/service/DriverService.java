package com.huashu.huashuManager.customerManage.driver.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.model.DriverInfo;

import java.util.List;

/**
 * 驾驶员管理服务类
 */
public interface DriverService {

    /**
     * 删除驾驶员
     * @param driverId
     * @return
     */
    int deleteDriver(String driverId);

    /**
     * 新增驾驶员
     * @param driverInfo
     * @return
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 列表驾驶员
     * @param driverInfo
     * @return
     */
    PageEntity<DriverInfo> pageListDrivers(DriverInfo driverInfo);

    /**
     * 获取驾驶员
     * @param driverInfo
     * @return
     */
    List<DriverInfo> getDriver(DriverInfo driverInfo);

    /**
     * 根据驾驶员id获取驾驶员
     * @param id
     * @return
     */
    DriverInfo getDriverById(String id);

    /**
     * 更新驾驶员
     * @param driverInfo
     * @return
     */
    int updateDriver(DriverInfo driverInfo);
}
