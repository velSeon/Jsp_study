package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.EmpDAO;
import com.dto.EmpDTO;

public class EmpService {
	//public int memberAdd(EmpDTO dto)
	
	public int memberAdd(EmpDTO dto) {
		EmpDAO dao = new EmpDAO();
		SqlSession session = MySqlSessionFactory.getSession();
		int num = 0;
		try {
			num = dao.membetAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
		
	}
	public List<EmpDTO> select() {
		//dao생성
		//MysqlSessionFactory에서 session얻기
		//dao의 select함수 호출하면서  session 전달,
		//select����� list���� �� session�ݱ� , list servlet���� ����
	EmpDAO dao = new EmpDAO();
	SqlSession session = MySqlSessionFactory.getSession();
	List<EmpDTO> list = null;
	try {
		list = dao.select(session);
	} finally {
		session.close();
	}
	return list;
	}//end select
	
	
	
}
