package wanTest.initialize.dao;

import java.util.List;

import wanTest.initialize.dto.Article;

public interface ArticleDao {
	public List<Object> getArticleInfo();
	
	public Object getArticleDetail(String title);
	
	public int updateArticleInfo(String id, String articleTitle, String articleContent);
}
