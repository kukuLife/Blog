package wanTest.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import wanTest.login.service.LoginService;
import wanTest.login.service.impl.LoginServiceImpl;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

@Controller
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value="/login", method=POST)
	public ModelAndView doLogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
		
		if(loginService.doLoginCheck(userName, passWord)) {	
			request.getSession().setAttribute("user", "user");
			return new ModelAndView("redirect:/initializeBlogListPage.action");
		} else {
			return new ModelAndView("loginError");
		}
	}
	
	@RequestMapping(value="/loginFromApp", method=GET)
	@ResponseBody
	public String loginCheckFromApp(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
		if(loginService.doLoginCheck(userName, passWord)) {
			request.getSession().setAttribute("user", "user");
			return "true";
		} else {
			return "false";
		} 
	}
}
