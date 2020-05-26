package com.command.write;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter 받아오기, 없으면 json 동작 디폴트로
		String reqType= request.getParameter("reqType");
		if(reqType == null) reqType = "json";
		
		
		// xml 혹은 json 으로 response 하기
		switch(reqType) {
		case "xml":
			responseXML(request, response);
			break;
		case "json":
			responseJSON(request, response);
			break;
		default:
			responseJSON(request, response);
		}
	}
	
	private void responseJSON(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO[] dtoArr = (WriteDTO[])request.getAttribute("list");
		
		JSONObject jsonOutput = new JSONObject(); // 최종 결과는 object 이다.
		
		if(dtoArr == null) {
			jsonOutput.put("status", "FAIL");
		} else {
			jsonOutput.put("status", "OK");
			int count = dtoArr.length;
			jsonOutput.put("count", count);
			
			//글 목록
			JSONArray dataArr = new JSONArray();
			
		    for (int i = 0; i < count; i++) {
		    	JSONObject dataObj = new JSONObject();
		    	
		    	dataObj.put("uid", dtoArr[i].getUid());
		    	dataObj.put("name", dtoArr[i].getName());
		    	dataObj.put("subject", dtoArr[i].getSubject());
		    	dataObj.put("content", dtoArr[i].getContent());
		    	dataObj.put("viewcnt", dtoArr[i].getViewCnt());
		    	dataObj.put("regdate", dtoArr[i].getRegDate());
		    	dataArr.put(dataObj);
				
			}
			
			jsonOutput.put("data", dataArr);
		}
		
		String jsonString = jsonOutput.toString(); // JSON --> String 변환
		
		response.setContentType("application/json; charset=utf-8"); //MIME 설정 -> application/json
		
		try {
			response.getWriter().write(jsonString); // response 내보내기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void responseXML(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO[] dtoArr = (WriteDTO[])request.getAttribute("list");
		
		Document dom = new Document();
		
		Element rootElement = new Element("WriteList"); // <WriteList>..</WriteList> 생성
		
		dom.setRootElement(rootElement);
		
		Element statusElement = new Element("status");
		if(dtoArr == null) {
			statusElement.setText("FAIL");
		} else {
			statusElement.setText("OK");
			
			// 데이터 개수 
			int cnt = dtoArr.length;
			Element countElement = new Element("count").setText("" + cnt).setAttribute("id", "ccc").setAttribute("pw", "sss");
			rootElement.addContent(countElement);
			
			for (int i = 0; i < cnt; i++) {
				Element dataElement = new Element("Data");
				
				dataElement.addContent(new Element("uid").setText("" + dtoArr[i].getUid()));
				dataElement.addContent(new Element("name").setText("" + dtoArr[i].getName()));
				dataElement.addContent(new Element("subject").setText("" + dtoArr[i].getSubject()));
				dataElement.addContent(new Element("content").setText("" + dtoArr[i].getContent()));
				dataElement.addContent(new Element("viewcnt").setText("" + dtoArr[i].getViewCnt()));
				dataElement.addContent(new Element("regdate").setText("" + dtoArr[i].getRegDate()));
				
				rootElement.addContent(dataElement);
			}
		}
		rootElement.addContent(statusElement);
		
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
		System.out.println(xmlOutputter.outputString(dom)); //테스트용
		
		try {
			response.setContentType("application/xml; charset=utf-8"); // text/xml 도 가능 
			response.getWriter().write(xmlOutputter.outputString(dom));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
















