package com.lec.sts19_rest.board.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.BWriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ajaxlistcommand");
		BWriteDTO [] dtoArr = (BWriteDTO [])request.getAttribute("list");
		
		AjaxWriteList result = new AjaxWriteList();
		
		result.setStatus((String)request.getAttribute("status"));
		result.setMessage((String)request.getAttribute("message"));
		
		if(dtoArr != null) {
			result.setCount(dtoArr.length);
			result.setList(Arrays.asList(dtoArr));
			System.out.println("result.setlist");
		}
		// 페이징 할때 필요한 값들
		try {			
			result.setPage((Integer)request.getAttribute("page"));
			result.setTotalPage((Integer)request.getAttribute("totalPages"));
			result.setWritePages((Integer)request.getAttribute("writePages"));
			result.setPageRows((Integer)request.getAttribute("pageRows"));
			result.setTotalCnt((Integer)request.getAttribute("totalCnt"));
		} catch(Exception e) {
			// 개 무시..    /view.ajax 에선 페이징 관련 변수값들이 없다..
		}
		ObjectMapper mapper = new ObjectMapper();  // Json 매핑할 객체
		try {
			System.out.println("mapper 후");
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			System.out.println("setcontett 전");
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonString);
			System.out.println("jsonString");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end execute()
	
	

} // end Command














