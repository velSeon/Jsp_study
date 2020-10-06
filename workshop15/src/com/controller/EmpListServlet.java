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
import com.dto.EmpDTO;
import com.service.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmpService service = new EmpService();
		List<EmpDTO> list = service.select();
		//EmpService select() 호출 list<EmpDTO>받아오기 
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		String my = "<table border='1'>";
		   my += "<tr>";
		   my += "<td>사원번호</td>";
		   my += "<td>사원이름</td>";
		   my += "<td>직업</td>";
		   my += "<td>담당매니저번호</td>";
		   my += "<td>입사일</td>";
		   my += "<td>월급</td>";
		   my += "<td>커미션</td>";
		   my += "<td>부서번호</td>";
		   my += "</tr>";
		//리스트에서 한명씩 꺼내서 표로 만들어 출력
		   for(EmpDTO emp : list) {
			   my+= "<tr>";
			   my+="<td>"+emp.getEmpno()+"</td>";
			   my+="<td>"+emp.getEname()+"</td>";
			   my+="<td>"+emp.getJob()+"</td>";
			   my+="<td>"+emp.getMgr()+"</td>";
			   my+="<td>"+emp.getHiredate()+"</td>";
			   my+="<td>"+emp.getSal()+"</td>";
			   my+="<td>"+emp.getComm()+"</td>";
			   my+="<td>"+emp.getDeptno()+"</td>";
			   my+= "</tr>";
		   
		   }
		   my += "</table>";
		   out.print(my);
		   out.print("</body>");
		   out.print("</html>");
	}

}
