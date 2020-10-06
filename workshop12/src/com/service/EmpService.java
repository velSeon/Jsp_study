package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.EmpDAO;
import com.dto.EmpDTO;


public class EmpService {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String pass = "tiger";
    private EmpDAO dao;
	
	public EmpService() {
		//DAO생성
		//드라이버 로딩
		dao = new EmpDAO();
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmpDTO> selectAllEmp() throws SQLException{
		//db에 컨넥션 연결
		//DAO에서 컨넥션 전송, public ArrayList<EmpDTO> selectAllEmp(Connection con){
		//emp를 담은  ARRAYLIST 받아서 서블릿으로 리턴
		Connection con = null;
		ArrayList<EmpDTO> list = null;
		try {
			con = DriverManager.getConnection(url,user,pass);
			list = dao.selectAllEmp(con);
		} finally {
			if(con == null) con.close();
		}
		return list;
		
	
		
	}
	
	
}
