package com.huashu.huashuManager.mapper;

import com.huashu.huashuManager.model.CarTrack;

public interface CarTrackMapper {
    void insertCarTrack(CarTrack carTrack);
    void insertCarMileage(CarTrack carTrack);
    void insertCarTotalMile(CarTrack carTrack);
    void updateCarTotal(CarTrack carTrack);
}
