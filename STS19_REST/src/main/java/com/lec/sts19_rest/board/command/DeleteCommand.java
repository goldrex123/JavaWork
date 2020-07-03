package com.lec.sts19_rest.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.SWriteDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		SWriteDAO dao = C.sqlSession.getMapper(SWriteDAO.class);

		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";
		
		// 유효성 검증
		String[] params = request.getParameterValues("uid");
		int[] uids = null;

		if (params == null || params.length == 0) {
			message.append("[유효하지 않은 parameter 0 or null");
		} else {
			uids = new int[params.length];
			
			try {
				for(int i = 0; i<params.length; i++) {
					uids[i]	= Integer.parseInt(params[i]);
					dao.deleteByUid(uids[i]);
					cnt++;
				}
				status = "OK";
			} catch (Exception e) {
				message.append("[트랜잭션 에러: " + e.getMessage() + "]");
			} 
//			catch (Exception e) {
//				message.append("[유효하지 않은 parameter]" + Arrays.toString(params));
//			}
		}

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}
