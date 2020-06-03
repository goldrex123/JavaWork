package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;
		
		// 첨부파일 정보도 update.jsp 화면에 보여주어야 한다
		FileDAO fileDao = new FileDAO();
		FileDTO [] fileArr = null;
		
		try {
			//트랜잭션 수행
			arr = dao.selectByUid(uid);
			
			//"selec" 란 name으로 request 에 arr 값 전달
			// 즉 request 에 담아서 컨트롤러에 전달되는 셈
			request.setAttribute("selec", arr);
			
			if(arr != null && arr.length == 1) {
				fileArr = fileDao.selectFileByWrUid(uid);
				request.setAttribute("file", fileArr);
			}
			
		} catch (SQLException e) {
			// 만약 cp 사용한다면
			// NamingException 도 처리 해야 함
			e.printStackTrace();
		}
	}

}
