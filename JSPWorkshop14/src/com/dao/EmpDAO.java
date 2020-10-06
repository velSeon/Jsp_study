package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.dto.TB;

public class EmpDAO {
	

	public List<TB> select(SqlSession session) {
		//Mapper에서  select 결과를 리스트에 담기
		//리스트 리턴
		List<TB> list = session.selectList("selectAll");
		return list;
	}
	
	
	
	
}
