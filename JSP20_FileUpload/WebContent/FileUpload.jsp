<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import = "com.oreilly.servlet.multipart.FileRenamePolicy" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<!-- parameter 값들, file 값 추출 -->
<%@ page import ="java.util.*" %>

<!-- File 객체 -->
<%@ page import="java.io.File" %>

<%-- 이미지 파일 다루기 --%>
<%@ page import ="java.awt.image.BufferedImage" %>
<%@ page import = "javax.imageio.ImageIO" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>파일 업로드 결과</title>
</head>
<body>

<form action="FileCheck.jsp" method="post" name="fileCheck">
	

<%
	//MultipartRequest 객체 생성 준비
	//String saveDirectory ="C://tomcat//upload";

	//파일 저장 경로
	//서버에서 어디에 어느 폴더에서 서블릿으로 변환되는지 알아내기
	ServletContext context = this.getServletContext();
	//서블릿상의 upload 폴더의 물리적인 경로 얻어오기
	String saveDirectory = context.getRealPath("upload"); 
	

	System.out.println("업로드 경로 : " + saveDirectory);
	
	// POST 받기 , 최대크기 5메가
	int maxPostSize = 5 * 1024 * 1024;
	String encoding = "utf-8";
	FileRenamePolicy policy = new DefaultFileRenamePolicy(); // 업로딩 파일 이름 중복에 대한 rename 정책
	
	MultipartRequest multi = null;
	
	try{ // jsp 파일에서 예외를 반드시 catch 할 필요는 없다
		
		// MultipartRequest 생성 단계에서 이미 파일은 저장됨
		multi = new MultipartRequest(
				request, //jsp 내부 객체
				saveDirectory, // 업로드된 파일 저장 경로
				maxPostSize, // 최대 파일 크기
				encoding,
				policy // 중복 이름의 파일 rename 객체
				);
	
		Enumeration names = null;
		
		// 1. Parameter name 들 추출
		names = multi.getParameterNames(); // 일반적인 form parameter name 추출
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String value = multi.getParameter(name);
			out.println(name + " : " + value + "<br>");
			
		}
		out.println("<hr>");
		// 2. file 들 추출
		names = multi.getFileNames(); // type="file" 요소 name들 추출
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			out.println("input name: " + name + "<br>");
			
			//위 name의 '업로드 원본 파일명'을 가져온다.
			String original = multi.getOriginalFileName(name);
			out.println("업로드 원본 파일명: " + original + "<br>");
			out.println("<input type='hidden' name='original' value='" + original + "'");
			
			// 서버 시스템에 저장된 파일명을 가져온다
			String fileSystemName = multi.getFilesystemName(name);
			out.println("시스템에 저장된 파일명: " + fileSystemName + "<br>");
			out.println("<input type='hidden' name='fileSystemName' value='" + fileSystemName + "'");
			
			//업로딩된 파일의 타입 : MIME 타입 (ex: image/png...)
			String fileType=multi.getContentType(name);
			out.println("파일타입: " + fileType + "<br>");
			
			// 문자열 '파일이름' 이 name 에 들어온 상태
			// 문자열 파일이름을 통해 실제 파일 정보를 -> File 객체로 가져오기
			File file = multi.getFile(name);
			if(file != null){
				long fileSize = file.length(); // 파일크기
				out.println("파일 크기 : " + fileSize + "bytes<br>");
				
				// 이미지 파일 다루기
				BufferedImage bi = ImageIO.read(file);
				if(bi != null){
					int width = bi.getWidth();
					int height = bi.getHeight();
					out.println("이미지파일 : " + width + " x " + height + "<br>");
				} else {
					out.println("이미지 아니다<br>");
				}
			}
			
			out.println("<hr>");
		}
		
		
		
	} catch (Exception e){
		e.printStackTrace();
	}
%>
<input type="submit" value="업로드 파일 확인"/><br>
</form>



</body>
</html>












