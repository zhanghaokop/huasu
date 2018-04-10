package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.CarTrack;

import java.util.List;

public interface CarTrackMapper {
    void insertCarTrack(CarTrack carTrack);
    void insertCarMileage(CarTrack carTrack);
    void insertCarTotalMile(CarTrack carTrack);
    void updateCarTotal(CarTrack carTrack);
    List<CarTrack> selectByTrackTime(CarTrack carTrack);
}
