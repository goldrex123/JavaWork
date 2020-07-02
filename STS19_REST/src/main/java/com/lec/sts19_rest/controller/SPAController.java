package com.lec.sts19_rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SPAController {
	
	@RequestMapping(value ="/rest")
	public String rest() {
		return "board/rest";
	}
}
