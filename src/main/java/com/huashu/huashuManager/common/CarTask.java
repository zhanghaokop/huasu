package com.huashu.huashuManager.common;

import com.huashu.huashuManager.carManager.service.BasicServiceImpl;
import com.huashu.huashuManager.common.utils.JIMIAPI;
import com.huashu.huashuManager.common.utils.JIMIAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: CarSchelduApplication.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/4 21:26
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Component
public class CarTask {
    @Autowired
    private BasicServiceImpl basicService;
    @Autowired
    private JIMIAPIService jimiapiServicel;

    @Scheduled(cron="0 0 0,6,12,18 * * ?") //每6小时执行一次
    public void statusCheck() {
        List<String> imeiList = basicService.getImeiLIst();
        if(CollectionUtils.isEmpty(imeiList))
            return;
           for(String imei : imeiList){
               jimiapiServicel.getCarTrack(imei);
           }
    }

    @Scheduled(cron="0 0 23 * *")
    public void testTasks() {
        System.out.print("BBBBBBBBBBBBBBBBB");
    }

}
