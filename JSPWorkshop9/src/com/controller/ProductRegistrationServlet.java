package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/productReg")
public class ProductRegistrationServlet extends HttpServlet {

	private HashMap<String, Product> products = new HashMap<String, Product>();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>상품입력결과</title></head><body>");
		out.println("<b>상품입력 결과</b><hr/>");	
		try{//데이터 파싱
			String name=request.getParameter("name");
			String id=request.getParameter("id");//map에 저장할  key
			int amount=Integer.parseInt(request.getParameter("amount"));
			//map에서 id를 이용 객체 꺼내오기
			Product temp=products.get(id);
			if(temp==null){//map 에 없는 경우 
				temp=new Product(name, id, amount); //사용자 데이터로 객체 생성
				products.put(id, temp);//생성된 객체를 map에 추가
			}else{//map 에 있는 경우 amount 값 증가
				temp.setAmount(temp.getAmount()+amount);//기존 amount를 가져와 사용자가 입력한 amount와 +gkrh ektl wjwkd
			}
				
			out.println("<table border='1'>");		
			out.println("<tr><th>상품명</th><th>상품아이디</th><th>수량</th></tr>");
			for(Product p : products.values()){//map에 value만 얻어오기 
				out.println("<tr>");
				out.println("<td>"+p.getName()+"</td><td>"+p.getId()+"</td><td>"+p.getAmount()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}catch(Exception e){
			out.println("입력항목을 확인해 주세요!<br/>");
		}
		out.println("<a href='productForm.html'>상품 입력하기</a>");
		out.println("</body></html>");
	}

}
