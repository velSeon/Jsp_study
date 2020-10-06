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


@WebServlet("/memberAddServlet")
public class memberAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(username, age, address);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", dto);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2>세션에 이름/나이/주소 저장 성공</h2>");
		out.print("<a href='MemberListServlet'>세션정보 보기</a>");
		out.print("</body></html>");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
