package com.lec.sts19_rest.board.beans;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface SWriteDAO {

	public int insert(BWriteDTO dto);
	
	public int insert(String subject, String content, String name);
	
	public BWriteDTO [] select();
	public int incViewCnt(int uid);
	
	public BWriteDTO [] selectFromRow(int from, int rows);
	
	public int countAll();
	
//	public BWriteDTO [] readByUid(int uid);
	
	public BWriteDTO[] selectByUid(int uid);
	
	public int update(int uid, String subject, String content);
	
	public int deleteByUid(int uid);
	
	public int deleteByUids(int [] uids);
}
