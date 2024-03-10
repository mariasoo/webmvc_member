package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("login get...");
        request.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("login post called...");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        try {
            MemberDTO dto = MemberService.INSTANCE.login(id, pw); // 아이디와 비밀번호를 받자
            HttpSession session = request.getSession(); //세션 값을 서버로부터 생성해달라고 받아와서
            session.setAttribute("loginInfo", dto);
            response.sendRedirect("/member/listMembers.do");
        } catch (Exception e) {
            response.sendRedirect("/login?result=error"); //로그인 화면으로 다시 출발
            // 갈때 이 에러라는 리졸트 값을 들고 가서 문제가 될 수 있는 부분을 처리하게 도와줌
        }
    }
}
