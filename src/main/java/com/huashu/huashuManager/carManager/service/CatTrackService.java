package com.huashu.huashuManager.carManager.service;

import com.huashu.huashuManager.model.CarTrack;

public interface CatTrackService {
    void insertCarTrack(CarTrack carTrack);
    void insertCarMileage(CarTrack carTrack);
    void insertCarTotalMile(CarTrack carTrack);
    void updateCarTotal(CarTrack carTrack);
}
