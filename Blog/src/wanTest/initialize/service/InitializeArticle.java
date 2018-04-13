package wanTest.initialize.service;

import java.util.List;

import wanTest.initialize.dto.Article;

public interface InitializeArticle {
	public List<Object> getArticleInfo();
	
	public Object getArticleDetail(String title);
}
