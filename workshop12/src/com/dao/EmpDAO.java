package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.ws.Response;

import com.dto.EmpDTO;


public class EmpDAO {
	public ArrayList<EmpDTO> selectAllEmp(Connection con) throws SQLException{
		//DB에서 데이터를 꺼내서  
		//emp 한명당 empDTO로 만들어 ArrayLIst에 저장 Arraylist 리턴
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select empno, ename, sal, to_char(hiredate,'yyyy/mm/dd') hiredate, deptno from emp order by empno";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		
		while(rs.next()) {
			EmpDTO emp = new EmpDTO();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setSal(rs.getInt(3));
			emp.setHiredate(rs.getString(4));
			emp.setDeptno(rs.getInt(5));
			list.add(emp);
		}
		if(rs!= null)rs.close();
		if(pstmt != null)pstmt.close();
		return list;
		
	}
	
}
