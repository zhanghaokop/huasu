package com.huashu.huashuManager.weixin.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@EnableConfigurationProperties(WeiXinServiceImpl.WeiXinProperties.class)
public class WeiXinServiceImpl implements WeiXinService {

    private WeiXinAuth2Service auth2Service;

    @Autowired
    private WeiXinProperties weiXinProperties;

    @PostConstruct
    public void init(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weixin.qq.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        auth2Service = retrofit.create(WeiXinAuth2Service.class);
    }

    @Override
    public String getOpenId(String code) {
        if (StringUtils.isBlank(code)) {
            return "";
        }

        Call<JSONObject> call = auth2Service.getAccessToken(weiXinProperties.getAppid(), weiXinProperties.getSecret(), code, "authorization_code");

        try {
            Response<JSONObject> response = call.execute();
            if (response.isSuccessful()) {
                JSONObject json = response.body();
                if (json != null && json.containsKey("openid")) {
                    return json.getString("openid");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @ConfigurationProperties("huasu.weixin.auth2")
    public static class WeiXinProperties {
        private String appid;

        private String secret;

        public String getAppid() {
            return appid;
        }

        public WeiXinProperties setAppid(String appid) {
            this.appid = appid;
            return this;
        }

        public String getSecret() {
            return secret;
        }

        public WeiXinProperties setSecret(String secret) {
            this.secret = secret;
            return this;
        }
    }

    /**
     * retrofit 微信http接口
     */
    interface WeiXinAuth2Service {

        @GET("sns/oauth2/access_token")
        Call<JSONObject> getAccessToken(@Query("appid") String appId, @Query("secret") String appSecret, @Query("code") String code, @Query("grant_type") String grantType);

    }
}
