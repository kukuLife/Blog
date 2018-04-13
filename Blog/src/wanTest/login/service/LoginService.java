package wanTest.login.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
	public boolean doLoginCheck(String userId, String passWord);

}
