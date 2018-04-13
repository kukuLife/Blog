package wanTest.detail.service;

public interface ArticleService {

	public Object getArticleDetail(String title);
	
	public int updateArticleInfo(String id, String articleTitle, String articleContent);
}
