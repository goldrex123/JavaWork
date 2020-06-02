package com.command.write;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int uid = Integer.parseInt(request.getParameter("uid"));

		WriteDAO dao = new WriteDAO();
		WriteDTO[] arr = null;
		
		// 첨부파일
		FileDAO fileDAO = new FileDAO();
		FileDTO [] fileArr = null;
		
		
		try {
			arr = dao.readByUid(uid);
			request.setAttribute("read", arr);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//첨부파일 읽어 들이기
		try {
			if(arr != null && arr.length == 1) {
				fileArr = fileDAO.selectFileByWrUid(uid); // 첨부 파일 읽어오기
				
				// 이미지 파일 여부 셋팅
				String realPath = "";
				String saveFolder = "upload";
				ServletContext context = request.getServletContext();
				realPath = context.getRealPath(saveFolder);
				
				for(FileDTO fileDto : fileArr) {
					String downloadedFilePath = realPath + File.separator + fileDto.getFile();
					BufferedImage imgDate = ImageIO.read(new File(downloadedFilePath));
					if(imgDate != null) {
						fileDto.setImage(true); // 이미지 맞네
					}
				}
				
				request.setAttribute("file", fileArr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
