package com.huashu.huashuManager.carManager.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huashu.huashuManager.model.CarTrack;

import java.util.List;

public interface CatTrackService {
    void insertCarTrack(CarTrack carTrack);
    void insertCarMileage(CarTrack carTrack);
    void insertCarTotalMile(CarTrack carTrack);
    void updateCarTotal(CarTrack carTrack);
    JSONArray selectByTrackTime(CarTrack carTrack);
    JSONObject getImeiTrackByTime(CarTrack carTrack);
    CarTrack selectTotalInfo(String imei);
}
