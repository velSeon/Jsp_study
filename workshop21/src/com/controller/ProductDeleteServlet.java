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


@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//id파싱
			//세션얻기
				String id = request.getParameter("id");
				HttpSession session = request.getSession();
					
	   	       request.setCharacterEncoding("UTF-8");
	   	       response.setContentType("text/html;charset=utf-8");
		       PrintWriter out = response.getWriter();
		       out.println("<html><body>");
		       Product p = (Product)session.getAttribute(id);
		       //System.out.println(id+"\t"+p.getId());
		       if( p != null && id.trim().equals(p.getId())) {
		    	   session.removeAttribute(id);
		    	   out.println("<h2>"+id+"상품 삭제 성공</h2>");
		    	   out.println("<a href='productFrom.html'>등록화면보기</a><br>");
		    	   out.println("<a href='ProductListServlet'>상품목록보기</a><br>");
		    	   
		       }else {
		    	   out.println("<h2>"+id+"상품은 등록되지 않는 상품입니다.</h2>");
		    	   out.println("<a href='ProductListServlet'>상품목록보기</a><br>");
		    	   out.println("<a href='productDelete.html'>특정상품삭제</a><br>");
		       }
		       out.println("</body></html>");
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
