package wanTest.initialize.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import wanTest.initialize.service.impl.InitializeArticelImpl;

@Controller
public class initializeLoginPageController {

	@Autowired
	private InitializeArticelImpl initializeArticleImpl;

	
    @RequestMapping(value="/initializeLogin",method=GET)
    public String initializeLoginPage() {
        return "login";
    }
    
    @RequestMapping(value="/initializeBlogListPage", method=GET)
    public String initializeBlogListPage(ModelMap model) {
    	
    	List<Object> articlesInfo = this.initializeArticleImpl.getArticleInfo();
    	
    	model.put("articlesInfo", articlesInfo);
    	
    	return "blogList";
    }
    
    
}
