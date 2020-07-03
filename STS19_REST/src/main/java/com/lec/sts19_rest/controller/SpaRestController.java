package com.lec.sts19_rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;
import com.lec.sts19_rest.board.command.AjaxListCommand;
import com.lec.sts19_rest.board.command.AjaxResultCommand;
import com.lec.sts19_rest.board.command.DeleteCommand;
import com.lec.sts19_rest.board.command.ListCommand;
import com.lec.sts19_rest.board.command.UpdateCommand;
import com.lec.sts19_rest.board.command.ViewCommand;
import com.lec.sts19_rest.board.command.WriteCommand;

@RestController
public class SpaRestController{
	
	// JSON 데이터 <-- 자바 list<>
	@RequestMapping("/list.ajax")
	public void listJSON(HttpServletRequest request, HttpServletResponse response){
		new ListCommand().execute(request, response);
		new AjaxListCommand().execute(request, response);
	}
	
	@RequestMapping("/view.ajax")
	public void viewJSON(HttpServletRequest request, HttpServletResponse response){
		new ViewCommand().execute(request, response);
		new AjaxListCommand().execute(request, response);
		
	}
	
	@RequestMapping("/writeOk.ajax")
	public void writeJSON(HttpServletRequest request, HttpServletResponse response){
		
		new WriteCommand().execute(request, response);
		new AjaxListCommand().execute(request, response);
		
	}
	
	@RequestMapping("/updateOk.ajax")
	public void updateJSON(HttpServletRequest request, HttpServletResponse response){
		
		new UpdateCommand().execute(request, response);
		new AjaxResultCommand().execute(request, response);
		
	}
	
	@RequestMapping("/deleteOk.ajax")
	public void deleteJSON(HttpServletRequest request, HttpServletResponse response){
		
		new DeleteCommand().execute(request, response);
		new AjaxResultCommand().execute(request, response);
		
	}
}















