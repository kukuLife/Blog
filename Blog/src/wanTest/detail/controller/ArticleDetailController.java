package wanTest.detail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import wanTest.detail.service.impl.ArticleServiceImpl;
import wanTest.initialize.dao.impl.ArticleDaoImpl;

@Controller
public class ArticleDetailController {
	
	@Autowired
	private ArticleServiceImpl articleServiceImpl;

	
	@RequestMapping(value="/articleDetail")
	public ModelAndView showArticleDetail(@RequestParam("articleId") String id, ModelMap modelMap) {
		
		modelMap.put("articleDetail",  this.articleServiceImpl.getArticleDetail(id));
		return new ModelAndView("blogDetail");
	
	}
	
	@RequestMapping(value="/updateBlogDetail")
	public ModelAndView updateArticleDetail(@RequestParam("articleId") String id, @RequestParam("articleTitle") String articleTitle, @RequestParam("articleContent") String articleContent) {	
		this.articleServiceImpl.updateArticleInfo(id, articleTitle, articleContent);
		return new ModelAndView("redirect:initializeBlogListPage.action");
	}
}
