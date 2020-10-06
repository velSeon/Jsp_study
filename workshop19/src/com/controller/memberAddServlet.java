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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");//데이터 파싱
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		MemberDTO dto = new MemberDTO(username, age, address);
		//세션생성
		HttpSession session = request.getSession();
		
			
		out.print("<html><body>");
		//중복검사
		MemberDTO xxx = (MemberDTO)session.getAttribute("user");//먼저 세션 검사
		if(xxx != null && username.trim().equals(xxx.getUsername())) {//null이 아닌 경우 이름 비교
			//같으면 저장 실패, 이름 입력화면 링크
			out.print("<h2>중복 데이터로 인한 이름 저장 실패</h2>");
			out.print("<a href='member.html'>학생 저장 화면 화면 </a>");
		}else {
			// nul인 경우 세션에 data 저장, 목록보기 페이지 링트
			session.setAttribute("user", dto);
			out.print("<h2>세션에 이름 저장 성공</h2>");
			out.print("<a href='MemberListServlet'>세션정보 보기 </a>");
		}
		
		out.print("</body></html>");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
