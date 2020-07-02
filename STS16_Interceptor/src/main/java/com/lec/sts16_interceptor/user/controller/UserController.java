package com.lec.sts16_interceptor.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	// 예제 : 테스트용 계정
	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
	
	@RequestMapping("/login")
	public String logIn() {
		return "user/login";
	}
	
	@RequestMapping(value="/loginOk", method= RequestMethod.POST)
	public String loginOk(String id, String pw, HttpSession session) {
		String returnURL = "";
		
		if(session.getAttribute("id") != null) {
			// 기존의 id 세션값이 존재한다면 (즉, 로그인 세션정보가 있는 상태라면)
			// 일단 이전 로그인 세션 정보 삭제
			session.removeAttribute("id");
		}
		
		if(ADMIN_ID.equals(id) && ADMIN_PW.equals(pw)) {
			//로그인 성공
			session.setAttribute("id", id);
			
			//원래 가고자 했던 url이 있었다면
			String priorUrl = (String)session.getAttribute("url_prior_login");
			if(priorUrl != null) {
				//있다면
				returnURL = "redirect:"+priorUrl;
				session.removeAttribute("url_prior_login");
			} else {
				//없었다면 디폴트로
				returnURL = "redirect:/board/list.do";
			}
			
		} else {
			// 로그인 실패
			returnURL = "/user/logfail";
		}
		
		return returnURL;
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("id");
		return "user/logout";
	}
}
