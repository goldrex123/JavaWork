package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employees") // <employees> 태그로 맹가짐
public class EmployeeListVO {
	
	//List 멤버
	@XmlElement      // <emp> ~~ </emp> 들로 만들어짐
	private List<EmployeeVO> emp = new ArrayList<EmployeeVO>();

	public List<EmployeeVO> getEmployees() {
		return emp;
	}
}
