package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "memberDeleteController", urlPatterns = "/member/deleteMember.do")
public class MemberDeleteController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            memberService.deleteMember(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("delete get error");
        }
        response.sendRedirect("/member/listMembers.do");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
