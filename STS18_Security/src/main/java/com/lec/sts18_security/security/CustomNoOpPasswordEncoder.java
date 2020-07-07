package com.lec.sts18_security.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("인코드 전 : " + rawPassword);
		return rawPassword.toString();
	}

	
	// 주어진 password 가 인코딩 된 비번과 동일한지 판정
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("matches 수행 : " + rawPassword + " :: " + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
	}

}
