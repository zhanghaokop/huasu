package com.huashu.huashuManager.auth;

import com.huashu.huashuManager.auth.ticket.model.Ticket;
import com.huashu.huashuManager.auth.ticket.repository.TicketRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录权限校验过滤器
 */
@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    @Autowired
    private TicketRepository ticketRepository;

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

        if (uri.contains("auth/login")) {
            chain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("token");

        if (StringUtils.isNotBlank(token)) {
            //校验token

            Ticket ticket = ticketRepository.getTicket(token);
            if(ticket != null){
                SessionStateHolder.set(ticket.getUser());
                chain.doFilter(request, response);
                return;
            }
        }

        //登录
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8;");
        response.getWriter().write("{\"code\":401,\"msg\":\"用户未登录\",\"data\":{}}");

    }

    @Override
    public void destroy() {

    }
}
