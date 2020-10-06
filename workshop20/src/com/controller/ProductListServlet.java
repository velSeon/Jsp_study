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


@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();//세션 얻기
		Enumeration<String> key = session.getAttributeNames();//전체 세션의 key값만 얻어오기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>상품입력결과</title></head><body>");
		out.println("<b>상품입력결과</b><hr/>");
		String my = "<table border='1'>";
		my+="<tr>";
		my+="<td>상품명</td>";
		my+="<td>상품 아이디</td>";
		my+="<td>상품수량</td>";
		my+="</tr>";
		while(key.hasMoreElements()) {//하나의 키가 있는 지 검사 true, false리턴
			String id = (String)key.nextElement(); //key 하나 저장
			Product p = (Product)session.getAttribute(id);//세션에서 key(제품id)
			//에 해당하는 객체를 가져옴
			my+="<tr>";
			my+="<td>"+p.getName()+"</td>";//실제 객체의 데이터에 접근
			my+="<td>"+p.getId()+"</td>";	//실제 객체의 데이터에 접근	
			my+="<td>"+p.getAmount()+"</td>";//실제 객체의 데이터에 접근
			my+="</tr>";
		}
		my+="</table>";
		out.print(my);
		out.print("<a href='productForm.html'>등록화면보기</a><br>");
		out.print("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
