package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConPath")
public class ContextPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContextPath() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//URL : Uniform Resource Locator
		StringBuffer url = request.getRequestURL();
		
		//URI : Uniform Resource Identifier
		String uri = request.getRequestURI();
		
		//Context Path
		String conPath = request.getContextPath();
		
		//domain 추출하기
		String url_domain = request.getScheme() + "://" + request.getServerName()
		+ " : " + request.getServerPort();
		
		ServletContext context = request.getServletContext();
		String servletContextName = context.getServletContextName(); //프로젝트 이름 (물리적 경로)
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		
		out.println("<hr>");
		out.println("URL: " + url + "<br>");
		out.println("URI: " + uri + "<br>");
		out.println("context path: " + conPath + "<br>");
		out.println("url domain: " + url_domain + "<br>");
		out.println("sesrvletcontextname: " + servletContextName + "<br>");
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
