package wanTest.detail.service.impl;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import wanTest.detail.service.ArticleService;
import wanTest.initialize.dao.impl.ArticleDaoImpl;


@Component
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDaoImpl articleDao;

	@Override
	public Object getArticleDetail(String id) {
		// TODO Auto-generated method stub
		return this.articleDao.getArticleDetail(id);
	}
	
	public int updateArticleInfo(String id, String articleTitle, String articleContent) {
		return this.articleDao.updateArticleInfo(id, articleTitle, articleContent);
	}
}
