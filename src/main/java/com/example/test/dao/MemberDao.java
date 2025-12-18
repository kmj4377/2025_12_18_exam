package com.example.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.test.dto.Member;

@Mapper
public interface MemberDao {
	
	@Insert("""
			insert into member
				set regDate = now()
					, updateDate = now()
					, loginId = #{loginId}
					, loginPw = #{loginPw}
					, name = #{name}
			""")
	void joinMember(String loginId, String loginPw, String name);
	
	@Select("""
			select *
				from member
				where loginId = #{loginId}
			""")
	Member getByLoginId(String loginId);

}
