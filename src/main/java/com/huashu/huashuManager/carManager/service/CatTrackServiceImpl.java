package com.huashu.huashuManager.carManager.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huashu.huashuManager.common.utils.JIMIAPIService;
import com.huashu.huashuManager.mapper.CarTrackMapper;
import com.huashu.huashuManager.model.CarTrack;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.nio.Buffer;
import java.util.List;

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
    @Resource
    private JIMIAPIService jimiapiService;


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

    @Override
    public JSONObject getImeiTrackByTime(CarTrack carTrack) {
       return  jimiapiService.getCarTrackByTime(carTrack);
    }

    @Override
    public JSONArray selectByTrackTime(CarTrack carTrack) {
        if(StringUtils.isEmpty(carTrack.getImei())||StringUtils.isEmpty(carTrack.getBeginTime())||StringUtils.isEmpty(carTrack.getEndTime()))
        throw new IllegalArgumentException("输入的参数不对，请输入开始时间结束时间和imei号");
        JSONObject obj = new JSONObject() ;
        JSONArray jsonArray =new JSONArray();
        List<CarTrack> list = carTrackMapper.selectByTrackTime(carTrack);
        StringBuffer str = new StringBuffer();
        str.append("[");
        for(CarTrack result: list){
           // jsonArray.add(result);
//            obj=JSON.parseObject(result.getTrackValue());
//            jsonArray.add(obj);
            String value = result.getTrackValue();
            if(StringUtils.isEmpty(value))
                continue;
            str.append(value.substring(1,value.length()-1));
           // obj.put(,jsonArray);
        }
        str.append("]");
        jsonArray = JSONArray.parseArray(str.toString());
        return jsonArray;
    }
}
