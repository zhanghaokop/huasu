package com.huashu.huashuManager.weixin.service;

/**
 * 微信公众号接口服务类
 */
public interface WeiXinService {

    /**
     * 根据授权码获取微信用户openID
     * @param code
     * @return
     */
    String getOpenId(String code);

}
