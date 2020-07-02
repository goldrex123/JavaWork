package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
			Map<String, Object> map = model.asMap();
			int uid = (Integer)map.get("uid");
			
//			BWriteDAO dao = new BWriteDAO();
//			BWriteDTO dto = dao.readByUid(uid);
//			model.addAttribute("list", Arrays.asList(dto));
			
			//Arrays.asList(new String[] {"aaa","bbb"})
			//Arrays.asList("aaa", "bbb")
			
			IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
			dao.incViewCnt(uid);
			model.addAttribute("list", dao.SelectByUid(uid));
	}

}
