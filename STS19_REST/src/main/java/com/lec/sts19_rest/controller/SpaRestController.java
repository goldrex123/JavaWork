package com.lec.sts19_rest.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.EmployeeListVO;
import com.lec.sts19_rest.board.beans.EmployeeVO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
public class SpaRestController{
	
	
	@RequestMapping("/helloJSON")
	public BWriteDTO helloJSON() {
		BWriteDTO dto = new BWriteDTO(100, "하이여", "REST", "JSON이다!" , 123	, new Timestamp(10000));
		
		return dto;
	}
	
	// JSON 데이터 <-- 자바 list<>
	@RequestMapping("/list.ajax")
	public List<BWriteDTO> listJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		return dao.select();
	}
	
	
	// json 데이터 <-- 자바 배열
	@RequestMapping("/arrJSON")
	public BWriteDTO[] arrJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		List<BWriteDTO> list = dao.select();
		BWriteDTO[] arr = new BWriteDTO[list.size()];
		
		return list.toArray(arr);
	}
	
	//JSON 데이터 <-- 자바 Map<k,v>
	@RequestMapping("/mapJSON")
	public Map<Integer, BWriteDTO> mapJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		List<BWriteDTO> list = dao.select();
		
		Map<Integer, BWriteDTO> map = new HashMap<Integer, BWriteDTO>();
		
		for(BWriteDTO dto : list) {
			map.put(dto.getUid(), dto);
		}
		
		return map;
	}
}















