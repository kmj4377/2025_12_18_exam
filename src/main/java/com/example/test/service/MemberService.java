package com.example.test.service;

import org.springframework.stereotype.Service;

import com.example.test.dao.MemberDao;
import com.example.test.dto.Member;

@Service
public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Member getByLoginId(String loginId) {
		return this.memberDao.getByLoginId(loginId); 
	}

	public void joinMember(String loginId, String loginPw, String name) {
		this.memberDao.joinMember(loginId, loginPw, name);
	}

}
