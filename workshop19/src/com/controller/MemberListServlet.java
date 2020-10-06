package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;


@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	
	MemberDTO dto = (MemberDTO)session.getAttribute("user");
	
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.print("<html><body>");
	if(dto == null) {
		out.print("잘못 접근, 회원등록 후 조회 가능");
	}else {
		out.print("세션에 등록된 정보: "+dto.getUsername()+"\t"+dto.getAge()+"\t"+dto.getAddress());
	}
	out.print("<a href='member.html'>회원등록화면</a>");
	out.print("</body></html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
