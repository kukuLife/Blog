package wanTest.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import wanTest.initialize.service.impl.InitializeArticelImpl;

@Controller
public class BlogInfoController {
	
	@Autowired
	private InitializeArticelImpl initializeArticleImpl;
	
    @RequestMapping(value="/blogListInfo", method=GET)
    @ResponseBody
    public List<Object> initializeBlogListPage() {
    	//Gson gson = new Gson();
    	List<Object> articlesInfo = this.initializeArticleImpl.getArticleInfo();
    	//String json = gson.toJson(articlesInfo);
    	return articlesInfo;
    }
}
