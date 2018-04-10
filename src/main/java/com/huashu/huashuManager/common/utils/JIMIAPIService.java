package com.huashu.huashuManager.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.huashu.huashuManager.carManager.service.CatTrackService;
import com.huashu.huashuManager.common.UtilConstants;
import com.huashu.huashuManager.model.CarTrack;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: JIMIAPIService.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/24 14:29
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Component
public class JIMIAPIService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private CatTrackService catTrackService;

    public  String  getToken() {
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("method", UtilConstants.JIMIAPI.JIMIGETTOKENMETHOD);
        map.put("app_key",UtilConstants.JIMIAPI.JIMIAPPKEY);
        map.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        map.put("sign_method","md5");
        map.put("v","1.0");
        map.put("format","json");
        map.put("user_id","HZHS");
        map.put("user_pwd_md5", DigestUtils.md5Hex("hzhs123"));
        map.put("expires_in", "7200");
        try {
            map.put("sign",JIMIAPI.signTopRequest(map,UtilConstants.JIMIAPI.JIMIAPPSECRET,"md5"));
        } catch (IOException e) {
            throw new IllegalArgumentException("jimi 参数不对");
        }
        StringBuffer strpara =new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()){
            strpara.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        String result =  RestClientUtil.exchange(UtilConstants.JIMIAPI.JIMIURL,strpara.toString());
        System.out.print("token:"+result);
        JSONObject obj= JSON.parseObject(result);
        JSONObject tokenJson = JSON.parseObject(obj.get("result").toString());
        redisTemplate.opsForValue().set("JIMITOKEN",tokenJson.get("accessToken").toString());
        redisTemplate.expire("JIMITOKEN",120, TimeUnit.SECONDS);
        return tokenJson.get("accessToken").toString();
    }

    public String getJIMITOKEN(){
        String token =redisTemplate.opsForValue().get("JIMITOKEN");
        if(!StringUtils.isEmpty(token)){
            return token; //todo redis整合，有问题
        }
        return getToken();
    }
    public static void main(String[] args) {
        JIMIAPIService a =new JIMIAPIService();
        CarTrack carTrack =new CarTrack();
        carTrack.setImei("868120158646593");
        carTrack.setBeginTime("2018-04-06 16:10:00");
        carTrack.setEndTime("2018-04-07 18:10:00");
        System.out.print(a.getCarTrackByTime(carTrack));

////        new JIMIAPIService().getCarTrack("868120158646593");
//             new JIMIAPIService().getGps("868120158646593");
    }

    public JSONObject getGps(String imei){
        Map<String,Object> map =new HashMap<>();
        map.put("method","jimi.device.location.get");
        map.put("timestamp",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        map.put("app_key",UtilConstants.JIMIAPI.JIMIAPPKEY);
        map.put("sign_method","md5");
        map.put("v","1.0");
        map.put("format","json");
        map.put("access_token",getJIMITOKEN());
        map.put("imeis",imei);
        map.put("map_type","BAIDU");
        try {
            map.put("sign",JIMIAPI.signTopRequest(map,UtilConstants.JIMIAPI.JIMIAPPSECRET,"md5"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer strpara= new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()){
            strpara.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        System.out.print(strpara);
        String result =  RestClientUtil.exchange(UtilConstants.JIMIAPI.JIMIURL,strpara.toString());
        System.out.print(result);
        JSONObject obj= JSON.parseObject(result);
        CarTrack carTrack=catTrackService.selectTotalInfo(imei);
        obj.put("totalMile",carTrack.getTotalMile());
        obj.put("plateNo",carTrack.getPlateNo());
        return obj;
    }


    public JSONObject getCarTrackByTime(CarTrack carTrack){
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("access_token",getJIMITOKEN());
//        map.put("access_token","1895098932cda8b8c0a0f0b626ac12cf");
        map.put("imei",carTrack.getImei()); //todo imei
        map.put("begin_time",carTrack.getBeginTime());
//        map.put("begin_time","2018-03-30 16:10:00");
        map.put("end_time",carTrack.getEndTime());
//        map.put("end_time","2018-03-30 20:10:00");
        map.put("map_type","BAIDU");
        map.put("method","jimi.device.track.list");
        map.put("timestamp",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        map.put("app_key",UtilConstants.JIMIAPI.JIMIAPPKEY);
        map.put("sign_method","md5");
        map.put("v","1.0");
        map.put("format","json");
        try {
            map.put("sign",JIMIAPI.signTopRequest(map,UtilConstants.JIMIAPI.JIMIAPPSECRET,"md5"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer strpara= new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()){
            strpara.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        String result =  RestClientUtil.exchange(UtilConstants.JIMIAPI.JIMIURL,strpara.toString());
        System.out.print("CarTrack:"+result);
        JSONObject obj= JSON.parseObject(result);
        //todo jia fanhui chepai
        return obj;
    }

    /**
     * 根据iemi定时获取形成
     * @param imei
     */
    public void getCarTrack(String imei){
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("access_token",getJIMITOKEN());
//        map.put("access_token","1895098932cda8b8c0a0f0b626ac12cf");
        map.put("imei",imei); //todo imei
        map.put("begin_time",getBeforeHourTime(6));
//        map.put("begin_time","2018-03-30 16:10:00");
        map.put("end_time",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        map.put("end_time","2018-03-30 20:10:00");
        map.put("map_type","BAIDU");
        map.put("method","jimi.device.track.list");
        map.put("timestamp",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        map.put("app_key",UtilConstants.JIMIAPI.JIMIAPPKEY);
        map.put("sign_method","md5");
        map.put("v","1.0");
        map.put("format","json");
        try {
            map.put("sign",JIMIAPI.signTopRequest(map,UtilConstants.JIMIAPI.JIMIAPPSECRET,"md5"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer strpara= new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()){
            strpara.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        String result =  RestClientUtil.exchange(UtilConstants.JIMIAPI.JIMIURL,strpara.toString());
        System.out.print("CarTrack:"+result);
        JSONObject obj= JSON.parseObject(result);
        double valueTotal;
        if("0".equals(obj.getString("code"))) {
            JSONArray carTrack = obj.getJSONArray("result");
            System.out.print(carTrack);
            CarTrack carTracBean = new CarTrack();
            carTracBean.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            carTracBean.setImei(imei);
            List<CarTrack> trackList = new ArrayList<CarTrack>();
            if(carTrack.isEmpty())
                return;
            for (Iterator iterator = carTrack.iterator(); iterator.hasNext(); ) {
                JSONObject carTrackValue = (JSONObject) iterator.next();
                carTracBean.setId(UUIDUtils.getUUID());
                carTracBean.setLat(carTrackValue.getString("lat"));
                carTracBean.setLng(carTrackValue.getString("lng"));
                carTracBean.setGpsTime(carTrackValue.getString("gpsTime"));
                //catTrackService.insertCarTrack(carTracBean);
                trackList.add(carTracBean);
            }
            carTracBean.setTrackValue(carTrack.toString());
            catTrackService.insertCarMileage(carTracBean);
            carTracBean.setTotalMile(getTotalMile(trackList));
            catTrackService.updateCarTotal(carTracBean);
        }else {
            throw new IllegalArgumentException(obj.getString("message"));
        }
    }

    public int getTotalMile(List<CarTrack> carList){
        double value=0;
        int num ;
        for(int i =1;i<carList.size()-1;i++){
            value=value+ calculateMile(carList.get(i).getLat(),carList.get(i).getLng(),carList.get(i+1).getLat(),carList.get(i+1).getLng());
        }
        try {
            num = (new Double(value)).intValue();
        }catch (Exception e){
            throw new IllegalArgumentException("里程转换失败");
        }

        return num ;
    }
    public double calculateMile(String lat_org,String lng_org,String lat_end,String lng_end ){
        if(StringUtils.isEmpty(lat_org)||StringUtils.isEmpty(lng_org)||StringUtils.isEmpty(lat_end)||StringUtils.isEmpty(lng_end)){
            return 0;
        }
        double R = 6370.99681;
        double PI =Math.PI;
        double PK =PI/180;
        double lat1 = PK * Double.parseDouble(lat_org);
        double lat2 = PK * Double.parseDouble(lng_org);
        double lng1 = PK * Double.parseDouble(lat_end);
        double lng2 = PK *Double.parseDouble(lng_end);
        double a=Math.sin(lat1)*Math.sin(lat2);
        double b=Math.cos(lat1)*Math.cos(lat2)*Math.cos(lng2-lng1);
        double c=Math.acos(a+b);
        double t=c*R;
        t = t * 1000;
        return t;
    }
    public static String getBeforeHourTime(int ihour){
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }
}
