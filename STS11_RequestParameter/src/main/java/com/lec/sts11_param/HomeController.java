package com.lec.sts11_param;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.beans.WriteDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// parameter 추출
	// handler 메소드에서도 서블릿에서 보았던 HttpServletRequest, HttpServletResponse 매개변수 가능
	@RequestMapping(value="/member/delete")
	public String delMember(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("mbId", id + ",");
		return "member/delete";
	}
	
	@RequestMapping(value="/member/regOk", method = RequestMethod.POST)
	public String regOkMember() {
		System.out.println("/member/regOk : POST");
		return "member/regOk";
	}
	
	@RequestMapping(value="/member/regOk", method = RequestMethod.GET)
	public String regOkMember(Model model) {
		System.out.println("/member/regOk : GET");
		return "member/regOk";
	}
	
	@RequestMapping(value="/member/regist")
	public String registMember() {
		return "member/regist";
	}
	
	// get / post 둘다 받는 handler
	@RequestMapping(value="/member/regOk2", method= {RequestMethod.GET, RequestMethod.POST} )
	public String regOkMember2() {
		return "member/regOk";
	}
	
	//handler 에
	//reqeust parameter 의 name 값과 '같은 이름의 매개변수' 가 있으면
	// 바로 그 매개변수가 reqeust parameter 값을 받아온다
	//public String findMember(int id, String name, Model model) { // 숫자 타입은 바로 parsing 해서 받는다
//	@RequestMapping("/member/find")
//	public String findMember(Model model, String[] name, int [] id) {
//		model.addAttribute("id", Arrays.toString(id));
//		model.addAttribute("name", Arrays.deepToString(name));
//		
//		return "member/find";
//	}
	
	@RequestMapping("/member/find")
	public String findMember(Model model, @RequestParam("id") String userid, @RequestParam("name") String username) {
		model.addAttribute("id", userid);
		model.addAttribute("name", username);
		
		return "member/find";
	}
	
	//------------------------------------
	// 커맨드 객체 사용
	@RequestMapping("/board/write")
	public String writeBoard() {
		return "board/write";
	}
	
	// 기존 방식으로 구현하기
	// 매 parameter 들을 매개변수화 해야한다. bad
//	@RequestMapping(value="/board/writeOk", method = RequestMethod.POST)	
//	public String writeOkBoard(Model model, @RequestParam("name") String name, @RequestParam("subject") String subject,
//			@RequestParam("content") String content) {
//		
//		WriteDTO dto = new WriteDTO();
//		dto.setName(name);
//		dto.setSubject(subject);
//		dto.setContent(content);
//		
//		model.addAttribute("dto", dto);
//		
//		return "board/writeOk";
//	}
	
	@RequestMapping(value="/board/writeOk", method = RequestMethod.POST)	
	public String writeOkBoard(WriteDTO dto) {
		
		return "board/writeOk";
	}
}














