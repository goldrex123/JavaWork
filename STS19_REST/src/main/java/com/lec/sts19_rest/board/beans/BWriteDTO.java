package com.lec.sts19_rest.board.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BWriteDTO {
	private int uid;     // wr_uid
	private String subject;   //wr_subject
	private String content;   //wr_content
	private String name;  // wr_name
	private int viewCnt;   // wr_viewcnt
	private Timestamp regDate;   // wr_regdate
	
	public BWriteDTO() {
		super();
	}
	public BWriteDTO(int uid, String subject, String content, String name, int viewCnt, Timestamp regDate) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	public int getUid() {
		System.out.println("uid" + uid);
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("2");
		this.uid = uid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		String timeStamp = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초").format(regDate);
		return timeStamp;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
}
