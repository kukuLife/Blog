package wanTest.logOut.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class logOutController {

	@Autowired
	private HttpServletRequest request;
		
	@Autowired 
	private HttpServletResponse response;
	@RequestMapping(value="/logOut")
	public String doLogOut() {
		request.getSession().removeAttribute("user");		
		try {
			response.sendRedirect("initializeLogin.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}
}
