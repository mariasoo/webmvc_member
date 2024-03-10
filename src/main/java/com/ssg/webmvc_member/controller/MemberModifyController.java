package com.ssg.webmvc_member.controller;

import com.ssg.webmvc_member.dto.MemberDTO;
import com.ssg.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "memberModifyController", urlPatterns = "/member/modifyMember.do")
public class MemberModifyController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            MemberDTO dto = memberService.selectMember(id);
            request.setAttribute("dto", dto);
            request.getRequestDispatcher("/WEB-INF/member/modify.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("modify get error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate date = LocalDate.parse(request.getParameter("date"));

        MemberDTO dto = MemberDTO.builder().id(id).pw(pw).name(name).email(email).date(date).build();
        try {
            memberService.modifyMember(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/listMembers.do");
    }
}
