package wanTest.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterCeptor extends HandlerInterceptorAdapter {

    private List<String> exceptUrls;  

    public List<String> getExceptUrls() {  
        return exceptUrls;  
    }  

    public void setExceptUrls(List<String> exceptUrls) {  
        this.exceptUrls = exceptUrls;  
    }  
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		
		
		boolean urlFlag = false;
		
		for(String url : exceptUrls) {
			if(url.equals(request.getRequestURI().substring(6))) {
				urlFlag = true;
			}
		}
		if(!urlFlag) {
			String loginCheckUser = (String)request.getSession().getAttribute("user");					
			if((null != loginCheckUser && "user".equals(loginCheckUser)) || "useragent".equals(request.getHeader("User-Agent").toLowerCase())) {
				return true;
			} else {
				response.sendRedirect("initializeLogin.action");
				return false;
			}			
		} else {
			return true;
		}
	}
	
}
