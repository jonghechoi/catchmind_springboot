package com.springboot.catchmind.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int update(String sid) {
		return sqlSession.update("mapper.admin.confirmUpdate", sid);
	}
	
	public int cancel(String sid) {
		return sqlSession.update("mapper.admin.CancelUpdate", sid);
	}
}
