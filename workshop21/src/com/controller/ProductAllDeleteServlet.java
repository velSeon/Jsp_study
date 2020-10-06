package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.Product;


@WebServlet("/ProductAllDeleteServlet")
public class ProductAllDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   	     //세션 삭제 - 로그아웃과 같다
				HttpSession session = request.getSession();
				session.invalidate();//세션정보 전체 삭제
			
			    request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				
				
				out.println("<html><body>");
				out.println("<h2>상품 전체 삭제 성공</h2>");
				out.println("<a href='productForm.html'>등록화면보기</a><br>");
				out.println("<a href='ProductListServlet'>상품목록보기</a><br>");
				out.println("</body></html>");
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
