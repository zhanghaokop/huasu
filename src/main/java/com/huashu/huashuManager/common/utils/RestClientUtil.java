package com.huashu.huashuManager.common.utils;

import com.github.pagehelper.util.StringUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: RestClientUtil.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/10 15:41
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class RestClientUtil {

    private static RestTemplate restTemplate;

    public RestClientUtil() {
    }

    static {
        restTemplate = new RestTemplate();
    }

    public static String exchangeCodeMessage(String url, String bodyValTemplate ,HashMap<String,String> info) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.set("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        headers.add("AppKey",info.get("appkey"));
        headers.add("CurTime",info.get("CurTime"));
        headers.add("Nonce",info.get("Nonce"));
        headers.add("CheckSum",info.get("CheckSum"));
        HttpEntity entity = new HttpEntity(bodyValTemplate, headers);
        System.out.println("=========调用接口结束，返回结果："+entity);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity,String.class);
        return result.getBody();
    }

    public static String exchange(String url, String objParams) {
        if (StringUtil.isEmpty(url) || StringUtil.isEmpty(objParams)) {
            return "参数不能为空";
        }
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.set("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        HttpEntity<String> entity = new HttpEntity<String>(objParams, headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return result.getBody();
    }
}
