package com.lec.sts15_mybatis.board.beans;

import java.util.List;

import javax.jws.soap.InitParam;

import org.mybatis.spring.annotation.MapperScan;
import org.apache.ibatis.annotations.Param;

@MapperScan
public interface IWriteDAO {
	public List<BWriteDTO> select();
	
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
	
	//public BWriteDTO readByUid(final int uid);
	
	public BWriteDTO SelectByUid(final int uid);
	
	public int update(final BWriteDTO dto);
	public int update(int uid, @Param("a") BWriteDTO dto);
	
	public int deleteByUid(final int uid);
	
	public int incViewCnt(int uid);
	
	public BWriteDTO searchBySubject(String subject);
}
