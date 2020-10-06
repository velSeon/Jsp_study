package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.EmpDTO;

public class EmpDAO {
	//public int membetAdd(SqlSession session, EmpDTO dto)

	public int membetAdd(SqlSession session, EmpDTO dto) {
		int num = session.insert("memberAdd", dto);
		return num;
	}
	
	public List<EmpDTO> select(SqlSession session) {
		//Mapper에서  select 결과를 리스트에 담기
		//리스트 리턴
		List<EmpDTO> list = session.selectList("selectAll");
		return list;
	}
	
	
	
}
