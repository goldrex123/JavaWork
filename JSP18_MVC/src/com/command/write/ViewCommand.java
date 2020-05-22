package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int uid = Integer.parseInt(request.getParameter("uid"));

		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;
		
		try {
		arr = dao.readByUid(uid);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("read", arr);

	}

}
