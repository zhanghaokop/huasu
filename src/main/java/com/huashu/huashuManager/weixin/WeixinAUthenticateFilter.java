package com.huashu.huashuManager.weixin;

import javax.servlet.*;
import java.io.IOException;

public class WeixinAUthenticateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //做一个session处理 登录状态


    }

    @Override
    public void destroy() {

    }
}
