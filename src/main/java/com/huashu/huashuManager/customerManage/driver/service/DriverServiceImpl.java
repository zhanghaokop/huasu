package com.huashu.huashuManager.customerManage.driver.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.mapper.DriverInfoMapper;
import com.huashu.huashuManager.model.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverInfoMapper mapper;

    @Override
    public int deleteDriver(String driverId) {
        return mapper.deleteByPrimaryKey(driverId);
    }

    @Override
    public int addDriver(DriverInfo driverInfo) {
        return mapper.insert(driverInfo);
    }

    @Override
    public PageEntity<DriverInfo> pageListDrivers(DriverInfo driverInfo) {
        PageEntity<DriverInfo> page = new PageEntity<DriverInfo>();
        page.setPageData( mapper.pageSelect(driverInfo));
        return page;
    }

    //统一采用list
    @Deprecated
    @Override
    public List<DriverInfo> getDriver(DriverInfo driverInfo) {
        return mapper.selectDriver(driverInfo);
    }

    @Override
    public DriverInfo getDriverById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateDriver(DriverInfo driverInfo) {
        return mapper.updateByPrimaryKey(driverInfo);
    }
}
