package com.lec.sts19_rest.board.command;

import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.SWriteDAO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("listcommand");
		SWriteDAO dao = C.sqlSession.getMapper(SWriteDAO.class);
		
		BWriteDTO[] arr = null;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";	
		
		// 페이징 관련 세팅값들
		int page = 1;
		int pageRows = 8; // 한 '페이이'에 몇개의 글을 리스트  (디폴트 8개)
		int writePages = 10; // 한 페이징에 몇개의 페이지 표현?
		int totalCnt = 0; // 총 몇개의 글?
		int totalPages = 0; // 총 몇페이지?
		
		String param;
		
		// page 값 : 현재 몇 페이지냐
		param = request.getParameter("page");
		if(param != null && param.trim().length() != 0) {
			try {
				page = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		//pageRows 값 : 한 페이지에 몇개의 글?
		param = request.getParameter("pageRows");
		if(param != null && param.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		try {
			// 글 전체 갯수 구하기
			totalCnt = dao.countAll();
			// 총 몇 페이지 분량인가
			totalPages = (int)Math.ceil(totalCnt / (double)pageRows);
			
			// 몇 번째 row부터
			int fromRow = (page - 1) * pageRows + 1; // oracle 은 1부터 rownum 시작
			
			arr = dao.selectFromRow(fromRow, pageRows);
			
			System.out.println("arr - " + arr[0].getRegDate());
			
			if(arr == null) {
				message.append("[리스트 할 데이터가 없습니다]");
			} else {
				status = "OK";
			}
			
		} catch (Exception e) {
			// 만약 cp 사용한다면
			// NamingException 도 처리 해야 함
//			e.printStackTrace();
			message.append("[트랜잭션 에러:" + e.getMessage() + "]");
		}
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);
		
		request.setAttribute("page", page);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("writePages", writePages);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("totalCnt", totalCnt);
	}

}
