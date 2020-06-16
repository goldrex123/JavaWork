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
		int depth = 1;
		int parent = 0;
		
		depth = Integer.parseInt(request.getParameter("depth"));
		parent = Integer.parseInt(request.getParameter("uid"));
		
		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] arr = null;
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


