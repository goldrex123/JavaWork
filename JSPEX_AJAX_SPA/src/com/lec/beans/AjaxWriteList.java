package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteList extends AjaxWriteResult {
	@JsonProperty("data")
	private List<WriteDTO> list; // 데이터 목록
	private int page; // 현재 페이지
	
	@JsonProperty("totalpage")
	private int totalPage;  // 총 페이지 수 
	
	@JsonProperty("totalcnt")	
	private int totalCnt; // 데이터(글) 수
	
	@JsonProperty("writepages")
	private int writePages; // 한 페이징에 몇개의 페이지를 표현할 것인가
	
	@JsonProperty("pagerows")
	private int pageRows; // 한 페이지에 몇개의 글을 리스트 할것인가
	
	public AjaxWriteList() {
		super();
	}
	
	public List<WriteDTO> getList() {
		return list;
	}
	public void setList(List<WriteDTO> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getWritePages() {
		return writePages;
	}
	public void setWritePages(int writePages) {
		this.writePages = writePages;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	
	
}
