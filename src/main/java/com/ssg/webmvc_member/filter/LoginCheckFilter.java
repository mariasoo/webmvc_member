package com.ssg.webmvc_member.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/member/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException,IOException{
        log.info("Login check filter....");

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") == null){

            resp.sendRedirect("/login"); // 세션값 새로 세팅해서 다른 리소스에 접근해라
            return;
        }
        chain.doFilter(request, response);
    }
}
