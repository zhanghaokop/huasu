package com.huashu.huashuManager.weixin;

import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WeixinAuthenticateFilter implements Filter {

    private String appid;

    private String redirectUrl;
    //微信重定向URL
    String wxRedirect;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        appid = filterConfig.getInitParameter("appid");

        try {
            redirectUrl = URLEncoder.encode("http://www.hsxnyqc.com/redirect.html","UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        wxRedirect = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" +
                redirectUrl + "&response_type=code&scope=snsapi_userinfo&state=state#wechat_redirect";

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //做一个session处理 登录状态
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //只校验微信端的请求，放过其他的请求

        String uri = request.getRequestURI();

        if (!uri.contains("/wxgzh/")) {
            chain.doFilter(request, response);
            return;
        }

        //只有注册过的用户才会用cookie
        Cookie wxCookie = WebUtils.getCookie(request, "wxToken");

        if (wxCookie != null) {

            chain.doFilter(request, response);

        } else {
            //重定向到微信服务器
            response.sendRedirect(wxRedirect);
        }

    }

    @Override
    public void destroy() {

    }
}