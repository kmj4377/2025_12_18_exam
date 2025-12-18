package com.example.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.test.dto.Article;

@Mapper
public interface ArticleDao {
	
	@Insert("""
			insert into article
				set regDate = now()
					, updateDate = now()
					, title = #{title}
					, content = #{content}
					, memberId = #{memberId}
			""")
	void writeArticle(String title, String content, int memberId);
	
	@Select("""
			select last_insert_id()
			""")
	int getLastArticleById();
	
	@Select("""
			select a.*, m.loginId as writerName
				from article as a
				inner join member as m
				on m.id = a.memberId
				order by a.id desc
			""")
	List<Article> getListArticle();
	
	@Select("""
			select a.*, m.loginId as writerName
				from article as a
				inner join member as m
				on m.id = a.memberId
				where a.id = #{id}
			""")
	Article getArticle(int id);
	
	@Update("""
			update article
				set updateDate = now()
					, title = #{title}
					, content = #{content}
			""")
	void modifyArticle(String title, String content);
	
	@Delete("""
			delete from article
				where id = #{id}
			""")
	void deleteArticle(int id);

}
