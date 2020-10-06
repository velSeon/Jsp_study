package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	public String driver="oracle.jdbc.driver.OracleDriver";
	public String url="jdbc:oracle:thin:@localhost:1521:orcl";
	public String userid ="scott";
	public String passwd ="tiger";
	
	public void init() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,userid, passwd);
			String sql = "select empno, ename, sal, to_char(hiredate,'yyyy/mm/dd') hiredate, deptno from emp order by empno";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			String my ="<table border='1'>";
			my+= "<tr><td>사원번호</td><td>사원이름</td><td>월급</td><td>입사일</td><td>부서번호</td></tr>";
			while(rs.next()) {
			my+="<tr>";
			my+="<td>"+rs.getInt("empno")+"</td>";
			my+="<td>"+rs.getString("ename")+"</td>";
			my+="<td>"+rs.getInt("sal")+"</td>";
			my+="<td>"+rs.getString("hiredate")+"</td>";
			my+="<td>"+rs.getInt("deptno")+"</td>";
			my+="</tr>";
			}
			my+="</table>";
			out.print(my);
			out.print("</body>");
			out.print("</html>");
			} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
