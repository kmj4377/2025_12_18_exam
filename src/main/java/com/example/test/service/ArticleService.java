package com.example.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.dao.ArticleDao;
import com.example.test.dto.Article;

@Service
public class ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void writeArticle(String title, String content, int memberId) {
		this.articleDao.writeArticle(title, content, memberId);
	}

	public int getLastArticleById() {
		return this.articleDao.getLastArticleById();
	}

	public List<Article> getListArticle() {
		return this.articleDao.getListArticle();
	}

	public Article getArticle(int id) {
		return this.articleDao.getArticle(id);
	}

	public void modifyArticle(String title, String content) {
		this.articleDao.modifyArticle(title, content);
	}

	public void deleteArticle(int id) {
		this.articleDao.deleteArticle(id);
	}

}
