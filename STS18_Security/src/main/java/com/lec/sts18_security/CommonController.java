package com.lec.sts18_security;

import javax.naming.AuthenticationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(AuthenticationException auth, Model model) {
		System.out.println("access denied : " + auth);
		model.addAttribute("msg", "접근권한거부");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error: " + error);
		System.out.println("logout: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "login error check your account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "logout!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("custom logout");
	}
	
	@PostMapping("/customLogout")
	public void logoutPOST() {
		System.out.println("post custom logout");
	}
}
