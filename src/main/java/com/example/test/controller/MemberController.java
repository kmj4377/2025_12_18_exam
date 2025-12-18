package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.dto.Member;
import com.example.test.service.MemberService;
import com.example.test.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService; 
	}
	
	@GetMapping("/usr/member/join") 
	public String join() {
		return "/usr/member/join";
	}
	
	@PostMapping("/usr/member/doJoin") 
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String loginPwChk, String name) {
		
		Member member = this.memberService.getByLoginId(loginId);
		
		if(member != null) {
			return Util.jsReplace(String.format("%s는 이미 사용중인 아이디입니다", loginId), "/usr/member/join");
		}
		
		this.memberService.joinMember(loginId, loginPw, name);
		
		return Util.jsReplace(String.format("%s님 회원가입 완료", loginId), "/");
	}
	
	@GetMapping("/usr/member/login") 
	public String login() {
		return "/usr/member/login";
	}
	
	@PostMapping("/usr/member/doLogin") 
	@ResponseBody
	public String doLogin(HttpSession session, String loginId, String loginPw) {
		Member member = this.memberService.getByLoginId(loginId);
		
		if(member == null) {
			return Util.jsReplace("없는 아이디입니다", "login");
		}
		
		session.setAttribute("loginedMemberId", member.getId());
				
		return Util.jsReplace(String.format("%s님 환영합니다", loginId), "/");
	}
	
	@GetMapping("/usr/member/logout") 
	@ResponseBody
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return Util.jsReplace("로그아웃", "/");
	}
}
