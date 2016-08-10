package com.naver.naverlogintutorial.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO {
	
	
	private SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Object insert(String queryId, Object params) {
		return sqlSession.insert(queryId, params);
	}

	public Object update(String queryId, Object params) {
		return sqlSession.update(queryId, params);
	}

	public Object delete(String queryId, Object params) {
		return sqlSession.delete(queryId, params);
	}

	public Object selectOne(String queryId) {
		return sqlSession.selectOne(queryId);
	}

	public Object selectOne(String queryId, Object params) {
		return sqlSession.selectOne(queryId, params);
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId) {
		return sqlSession.selectList(queryId);
	}

	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params) {
		return sqlSession.selectList(queryId, params);
	}
}
