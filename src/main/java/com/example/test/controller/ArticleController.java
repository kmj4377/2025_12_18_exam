package com.example.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.dto.Article;
import com.example.test.service.ArticleService;
import com.example.test.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class ArticleController {
	private ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/usr/article/write")
	public String write() {
		return "/usr/article/write";
	}
	
	@PostMapping("/usr/article/doWrite") 
	@ResponseBody
	public String doWrite(HttpSession session, String title, String content) {
		
		this.articleService.writeArticle(title, content, (int) session.getAttribute("loginedMemberId"));
		
		int id = this.articleService.getLastArticleById();
		
		
		return Util.jsReplace(String.format("%d번 글작성 완료 하였습니다!", id), "list");
	}
	
	@GetMapping("/usr/article/list")
	public String list(Model model) {
		
		List<Article> articles = this.articleService.getListArticle();
		
		model.addAttribute("articles", articles);
		
		return "/usr/article/list";
	}
	
	@GetMapping("/usr/article/detail")
	public String detail(Model model, int id) {
		
		Article article = this.articleService.getArticle(id);
		model.addAttribute("article", article);
		
		return "/usr/article/detail";
	}
	
	@GetMapping("/usr/article/modify")
	public String modify(Model model, int id) {
		
		Article article = this.articleService.getArticle(id);
		model.addAttribute("article", article);
		
		return "/usr/article/modify";
	}
	
	@PostMapping("/usr/article/doModify") 
	@ResponseBody
	public String doModify(int id, String title, String content) {
		
		this.articleService.modifyArticle(title, content);
		
		return Util.jsReplace(String.format("%d번 글 수정 완료하였습니다!", id),String.format("detail?id=%d", id));
	}
	
	@GetMapping("/usr/article/delete")
	@ResponseBody
	public String modify(int id) {
		
		this.articleService.deleteArticle(id);
		
		return Util.jsReplace(String.format("%d번 글 삭제 완료하였습니다!", id), "list");
	}
}
