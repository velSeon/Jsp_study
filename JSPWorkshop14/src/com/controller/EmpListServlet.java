package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDAO;

import com.dto.TB;
import com.service.EmpService;


@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmpService service = new EmpService();
		List<TB> list = service.select();
		//EmpService select() 호출 list<EmpDTO>받아오기 
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		String my = "<table border='1'>";
		   my += "<tr>";
		   my += "<td>학번</td>";
		   my += "<td>학과번호</td>";
		   my += "<td>이름</td>";
		   my += "<td>주민번호</td>";
		   my += "<td>주소</td>";
		   my += "<td>입학년도</td>";
		   my += "<td>휴학여부</td>";
		   my += "</tr>";
		//리스트에서 한명씩 꺼내서 표로 만들어 출력
		   for(TB tb : list) {
			   my+= "<tr>";
			   my+="<td>"+tb.getStudent_no()+"</td>";
			   my+="<td>"+tb.getDepartment_no()+"</td>";
			   my+="<td>"+tb.getStudent_name()+"</td>";
			   my+="<td>"+tb.getStudent_ssn()+"</td>";
			   my+="<td>"+tb.getStudent_address()+"</td>";
			   my+="<td>"+tb.getEntrance_date()+"</td>";
			   my+="<td>"+tb.getAbsence_yn()+"</td>";
			   
			   my+= "</tr>";
		   
		   }
		   my += "</table>";
		   out.print(my);
		   out.print("</body>");
		   out.print("</html>");
	}

}
