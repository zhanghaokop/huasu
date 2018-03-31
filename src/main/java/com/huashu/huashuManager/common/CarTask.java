package com.huashu.huashuManager.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void statusCheck() {
       System.out.print("aaaaaaaaa");
    }

    @Scheduled(cron="0 0 23 * *")
    public void testTasks() {
        System.out.print("BBBBBBBBBBBBBBBBB");
    }

}
