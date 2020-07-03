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
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.EmployeeListVO;
import com.lec.sts19_rest.board.beans.EmployeeVO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {
	
	@RequestMapping("/")
	public String helloTEXT() {
		return "Hello REST";
	}
	
//	@RequestMapping("/helloJSON")
//	public BWriteDTO helloJSON() {
//		BWriteDTO dto = new BWriteDTO(100, "하이여", "REST", "JSON이다!" , 123	, new Timestamp(10000));
//		
//		return dto;
//	}
	
	// JSON 데이터 <-- 자바 list<>
	@RequestMapping("/listJSON")
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
	
	// xml 데이터 <-- 자바 객체 
	@RequestMapping("/helloXML")
	public EmployeeVO helloXML() {
		return new EmployeeVO(100, "홍길동", 200, new int[] {10,20,30}, 34.2);
	}
	
	@RequestMapping("/hellojs")
	public AjaxWriteList hellojs() {
		return new AjaxWriteList();
	}
	
	// xml 데이터 <-- 자바 List<>
	@RequestMapping("/listXML")
	public EmployeeListVO listXML() {
		EmployeeListVO employees = new EmployeeListVO();
		
		EmployeeVO emp1 = new EmployeeVO(1, "김재현", 25, new int[] {7,6,4}, 34.2);
		EmployeeVO emp2 = new EmployeeVO(2, "김재", 26, new int[] {75,65,45}, 4.2);
		EmployeeVO emp3 = new EmployeeVO(3, "김현", 27, new int[] {73,63,43}, 3.2);
		
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
		employees.getEmployees().add(emp3);
		
		return employees;
	}
	
	@RequestMapping("/read/{uid}")
	public ResponseEntity<BWriteDTO> read(@PathVariable("uid") int uid) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = dao.SelectByUid(uid);
		
		// 실패
		if(dto == null) return new ResponseEntity(HttpStatus.NOT_FOUND);  // 404 
		
		// 성공
		return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK); // 200
	}
	
}















