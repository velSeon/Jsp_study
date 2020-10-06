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
import com.sun.jmx.snmp.EnumRowStatus;


@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8"); //한글처리	 
	 
	 String name = request.getParameter("name");
	 String id = request.getParameter("id");//제품번호를 세션의 키 값으로 지정
	 int amount = Integer.parseInt(request.getParameter("amount"));//데이터 파싱
	 //세션 얻기
	 HttpSession session = request.getSession();
	 Product p = (Product)session.getAttribute(id);//최초인 경우 id에 해당하는 객체가 없어 null
	 //두번째 돌아온 경우 id로 찾아서 있는 경우 하단 else의 수령증가 코드 실행
	 //없는 경우는 세션에 객체를 넣는 코드 실행
	
	 if(p ==null) {
		 p = new Product(name, id, amount);//최초에 없으므로 session에 객체이름 으로 넣기
		 session.setAttribute(id, p);//제품번호로 객체 session에 넣기
	 }else {
		 p.setAmount(p.getAmount()+amount);//기존 객체에 수령 증가
		
	 }
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();//등록 완성 및 링크 걸기
	 out.println("<html><body>");
	 out.println("<h2>상품 등록 성공</h2>");
	 out.println("<a href='productForm.html'>등록화면보기</a><br>");
	 out.println("<a href='ProductListServlet'>상품목록보기</a><br>");
	 out.println("</body></html>");
	 
	 
	 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
