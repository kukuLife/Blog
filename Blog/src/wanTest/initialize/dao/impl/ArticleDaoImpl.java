package wanTest.initialize.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import wanTest.initialize.dao.ArticleDao;
import wanTest.initialize.dto.Article;


@Component
public class ArticleDaoImpl implements ArticleDao {
	
	private SqlSession sqlSession;
	
	public List<Object> getArticleInfo() {
		return (List<Object>)(this.sqlSession.selectList("wanTest.initialize.mapper.selectArticleInfoMapper.selectArticleInfo"));
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Object getArticleDetail(String id) {
		return this.sqlSession.selectOne("wanTest.initialize.mapper.selectArticleInfoMapper.selectArticleDetail", id);
	}

	@Override
	public int updateArticleInfo(String id, String articleTitle, String articleContent) {
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("id", id);
		parameterMap.put("articleTitle", articleTitle);
		parameterMap.put("articleContent", articleContent);
		
		return this.sqlSession.update("wanTest.initialize.mapper.updateArticleDetailMapper.updateArticleDetail", parameterMap);
	}
}
