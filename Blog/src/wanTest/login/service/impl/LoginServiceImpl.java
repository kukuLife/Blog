package wanTest.login.service.impl;

import wanTest.login.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wanTest.login.dao.UserDao;
import wanTest.login.dao.impl.UserDaoImpl;
import wanTest.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDaoImpl userDao;
	 
	@Override
	public boolean doLoginCheck(String userName, String passWord) {
		// TODO Auto-generated method stub		
		User userInfo = userDao.getUserInfo(userName);		
		if(null != userInfo && passWord.equals(userInfo.getPassword())) {
			return true;			
		}
		return false;	
	}
}
