package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// POJO : Plain Old Java Object
public class AjaxWriteListJson {
	int count; // 데이터 개수
	String status; //처리결과

	@JsonIgnore
	String memo; // response 에서 제외할 필드
	
	@JsonProperty("data") //json property 이름과 java 필드명이 다른 경우 
	List<WriteDTO> list;
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public List<WriteDTO> getList() {
		return list;
	}
	
	public void setList(List<WriteDTO> list) {
		this.list = list;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
