package com.lec.spring.config04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.beans.Score;

@Configuration
@ImportResource("classpath:appCtx04.xml")
public class AppConfig04 {
	@Bean
	public Score score2() {
		return new Score(60,35,40,"나빠요");
	}
	
	@Bean
	public Score score1() {
		return new Score(60,77,7,"럭키");
	}
}
