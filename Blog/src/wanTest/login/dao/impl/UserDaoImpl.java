package wanTest.login.dao.impl;

import wanTest.login.dto.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.*;
import org.springframework.stereotype.Component;

import wanTest.login.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao {

	private SqlSession sqlSession;
		
	@Override
	public User getUserInfo(String userId) {
		return (User)sqlSession.selectOne("wanTest.login.mapper.selectUserInfoMapper.selectUserInfo", userId);				
	}
	
	  public void setSqlSession(SqlSession sqlSession) {
		  this.sqlSession = sqlSession;
	  }
}
