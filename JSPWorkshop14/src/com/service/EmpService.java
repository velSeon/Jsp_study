package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.EmpDAO;

import com.dto.TB;

public class EmpService {
	

	public List<TB> select() {
		//dao생성
		//MysqlSessionFactory에서 session얻기
		//dao의 select함수 호출하면서  session 전달,
		//select����� list���� �� session�ݱ� , list servlet���� ����
	EmpDAO dao = new EmpDAO();
	SqlSession session = MySqlSessionFactory.getSession();
	List<TB> list = null;
	try {
		list = dao.select(session);
	} finally {
		session.close();
	}
	return list;
	}//end select
	
	
	
}
