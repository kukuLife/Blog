package wanTest.initialize.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wanTest.initialize.dao.ArticleDao;
import wanTest.initialize.dao.impl.ArticleDaoImpl;
import wanTest.initialize.dto.Article;
import wanTest.initialize.service.InitializeArticle;
import wanTest.login.dao.impl.UserDaoImpl;



@Component
public class InitializeArticelImpl implements InitializeArticle {

	@Autowired
	private ArticleDaoImpl articleDao;
	
	@Override
	public List<Object> getArticleInfo() {
		// TODO Auto-generated method stub
		return this.articleDao.getArticleInfo();
	}

	@Override
	public Object getArticleDetail(String id) {
		// TODO Auto-generated method stub
		return this.articleDao.getArticleDetail(id);
	}	
}
