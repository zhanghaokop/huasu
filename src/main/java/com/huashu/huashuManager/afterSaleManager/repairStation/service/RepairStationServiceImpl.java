package com.huashu.huashuManager.afterSaleManager.repairStation.service;

import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.mapper.RepairStationMapper;
import com.huashu.huashuManager.model.RepairStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairStationServiceImpl implements RepairStationService {

    @Autowired
    private RepairStationMapper mapper;

    private double R = 6370.99681;

    private double pk = Math.PI/180;

    @Override
    public int addRepairStation(RepairStation station) {
        return mapper.insert(station);
    }

    @Override
    public int update(RepairStation station) {
        return mapper.updateByPrimaryKey(station);
    }

    @Override
    public int delete(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<RepairStation> getAll() {
        return mapper.selectAll();
    }

    @Override
    public PageEntity<RepairStation> pageListStation(RepairStation station) {

        PageEntity<RepairStation> entity = new PageEntity<>();
        entity.setPageData(mapper.pageSelect(station));

        return entity;
    }

    @Override
    public List<RepairStation> getNearBy(RepairStation station) {
        double latTar = pk * Double.parseDouble(station.getLat());
        double lngTar = pk * Double.parseDouble(station.getLng());

        return getAll().stream().filter( s -> 20 > calculate(latTar, lngTar, s)).collect(Collectors.toList());

    }

    /**
     * 计算两个坐标之间的距离
     * @param lat
     * @param lng
     * @param station
     * @return
     */
    private double calculate(double lat, double lng, RepairStation station){

        double _lat = pk * Double.parseDouble(station.getLat());
        double _lng = pk * Double.parseDouble(station.getLng());

        double a = Math.sin(lat) * Math.sin(_lat);
        double b = Math.cos(lat) * Math.cos(_lat) * Math.cos(_lng - lng);
        double c = Math.acos(a+b);

        return c * R;
    }
}
