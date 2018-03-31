package com.huashu.huashuManager.weixin;

import com.huashu.huashuManager.auth.SessionState;
import com.huashu.huashuManager.auth.SessionStateHolder;
import com.huashu.huashuManager.common.bo.PageEntity;
import com.huashu.huashuManager.customerManage.member.service.MemberService;
import com.huashu.huashuManager.model.Member;
import com.huashu.huashuManager.weixin.service.WeiXinService;
import com.huashu.huashuManager.weixin.service.WeiXinServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class WeixinAuthenticateFilter implements Filter {

    private Pattern ignorePath = Pattern.compile("/wxgzh/register|/WEB-INF/views/|\\.css|\\.js|\\.ico|\\.jpg|/img/|/sms/");

    @Autowired
    private WeiXinServiceImpl.WeiXinProperties weiXinProperties;

    //微信重定向URL
    private String wxRedirect;

    @Autowired
    private WeiXinService weiXinService;

    @Autowired
    private MemberService memberService;

    private Map<String, String> routeMap = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            String redirectUrl = URLEncoder.encode("http://www.hsxnyqc.com/huasu/wxgzh/redirect","UTF-8");
            wxRedirect = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + weiXinProperties.getAppid() + "&redirect_uri=" +
                    redirectUrl + "&response_type=code&scope=snsapi_base&state=";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        routeMap.put("0","main");
        routeMap.put("1","knowledgeList"); //常见问题

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //做一个session处理 登录状态
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //只校验微信端的请求，放过其他的请求

        String uri = request.getRequestURI();

        //微信重定向回来的
        if (uri.contains("/redirect")) {
            //微信重定向回来的，校验code
            String code = request.getParameter("code");

            String openId = weiXinService.getOpenId(code);

            if (StringUtils.isNotBlank(openId)) {
                //不存在的话 跳转的注册页面，存在的话跳转到对应的数据页面
                Member member = memberService.getMemberByOpenId(openId);
                if (member != null) {
                    //重定向到state指向的页面

                    Cookie wxToken = new Cookie("wxToken", member.getOpenId());
                    wxToken.setHttpOnly(true);
                    wxToken.setMaxAge(15 * 24 * 60 * 60);

                    response.addCookie(wxToken);

                    String state = request.getParameter("state");
                    response.sendRedirect(routeMap.get(state));
                } else {
                    //重定向到注册页面
                    response.sendRedirect("register?openId=" + openId);
                }
            }

            return;

        }

        //注册逻辑放行
        if (ignorePath.matcher(uri).find()) {
            chain.doFilter(request, response);
            return;
        }

        //只有注册过的用户才会用cookie
        Cookie wxCookie = WebUtils.getCookie(request, "wxToken");

        if (wxCookie != null) {

            SessionState state = new SessionState();
            state.addAttr("openId", wxCookie.getValue());
            addPageInfoIfExist(state, request);

            SessionStateHolder.set(state);

            try {
                chain.doFilter(request, response);
            } finally {
                SessionStateHolder.clear();
            }

        } else {
            //重定向到微信服务器
            for (Map.Entry<String, String> entry : routeMap.entrySet()) {
                if (uri.contains(entry.getValue())) {
                    String redirect = wxRedirect + entry.getKey() + "#wechat_redirect";
                    response.sendRedirect(redirect);
                    break;
                }
            }

        }

    }


    private void addPageInfoIfExist(SessionState state, HttpServletRequest request){
        String pageSize = request.getParameter("pageSize");
        String pageIndex = request.getParameter("pageIndex");

        PageEntity page = new PageEntity();


        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.parseInt(pageSize));
        }

        if (StringUtils.isNotBlank(pageIndex)) {
            page.setPageIndex(Integer.parseInt(pageIndex));
        }

        state.addAttr("pageEntity", page);

    }

    @Override
    public void destroy() {

    }
}