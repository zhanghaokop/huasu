package com.huashu.huashuManager.auth;

import com.huashu.huashuManager.auth.ticket.model.Ticket;
import com.huashu.huashuManager.auth.ticket.repository.TicketRepository;
import com.huashu.huashuManager.common.bo.PageEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 登录权限校验过滤器
 */
public class AuthenticationFilter implements Filter {

    @Autowired
    private TicketRepository ticketRepository;

    private Pattern ignorePath = Pattern.compile("auth/login|swagger|v2/api-docs|/wxgzh/");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
            chain.doFilter(request, response);
            return;
        }

        String uri = request.getRequestURI();

        if (shouldSkip(request, uri)) {
            chain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");

        if (StringUtils.isBlank(token)) {
            token = request.getParameter("token");
        }

        if (StringUtils.isNotBlank(token)) {
            //校验token

            Ticket ticket = ticketRepository.getTicket(token);
            if(ticket != null){

                SessionState state = new SessionState();
                state.setUser(ticket.getUser());

                addPageInfoIfExist(state, request);

                SessionStateHolder.set(state);
                try {
                    chain.doFilter(request, response);
                    return;
                } finally {
                    SessionStateHolder.clear();
                }
            }
        }

        //登录
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8;");
        response.getWriter().write("{\"code\":401,\"msg\":\"用户未登录\",\"data\":{}}");

    }

    private boolean shouldSkip(HttpServletRequest request, String uri){
        return ignorePath.matcher(uri).find();
    }

    private void addPageInfoIfExist(SessionState state, HttpServletRequest request){
        String pageSize = request.getParameter("pageSize");
        String pageIndex = request.getParameter("pageIndex");

        if (StringUtils.isNotBlank(pageSize) && StringUtils.isNotBlank(pageIndex)) {
            PageEntity page = new PageEntity();
            page.setPageIndex(Integer.parseInt(pageIndex));
            page.setPageSize(Integer.parseInt(pageSize));
            state.addAttr("pageEntity", page);
        }
    }

    @Override
    public void destroy() {

    }
}
