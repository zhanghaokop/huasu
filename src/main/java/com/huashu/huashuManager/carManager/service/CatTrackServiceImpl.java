package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.mapper.CarTrackMapper;
import com.huashu.huashuManager.model.CarTrack;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: CatTrackServiceImpl.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/24 18:44
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Transactional
@Service
public class CatTrackServiceImpl implements CatTrackService{

    @Resource
    private CarTrackMapper carTrackMapper;
    @Override
    public void insertCarTrack(CarTrack carTrack) {
        carTrackMapper.insertCarTrack(carTrack);
    }

    @Override
    public void insertCarMileage(CarTrack carTrack) {
        carTrackMapper.insertCarMileage(carTrack);
    }

    @Override
    public void insertCarTotalMile(CarTrack carTrack) {
        carTrackMapper.insertCarTotalMile(carTrack);
    }

    @Override
    public void updateCarTotal(CarTrack carTrack) {
        carTrackMapper.updateCarTotal(carTrack);
    }
}
