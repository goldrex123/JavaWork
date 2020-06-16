package com.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxCategory;
import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CategoryListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		int depth;
		int parent;
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] arr = null;
		
		String param = request.getParameter("depth");
		if(param == null || param.trim().length() == 0) {
			depth = 1;
		} else {
			depth= Integer.parseInt(param);
		}
		if(depth == 1) {
			parent = 0;
		}
		param = request.getParameter("uid");
		
		if(param == null || param.trim().length() == 0) {
			parent = 0;
		} else {
			parent = Integer.parseInt(param);
		}
		
		if(depth >= 2 && parent == 0) {
			message.append("0개의 데이터");
		} else {
			try {
				arr = dao.SelectByCategory(depth, parent);
				
				if(arr == null) {
					message.append("[리스트 할 데이터가 없습니다]");
				} else {
					status = "OK";
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		
		AjaxCategory result = new AjaxCategory();
		
		result.setStatus(status);
		result.setMessage(message.toString());
		
		if(arr != null) {
			result.setCount(arr.length);
			result.setList(Arrays.asList(arr));
		}
		
		ObjectMapper mapper = new ObjectMapper();  // Json 매핑할 객체
		
		try {
			String jsonString = 
					mapper.writerWithDefaultPrettyPrinter()
						.writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8"); 
			response.getWriter().write(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end execute()
}


