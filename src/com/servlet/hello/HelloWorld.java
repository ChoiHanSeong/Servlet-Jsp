package com.servlet.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션을 이용해서 여러개의 url 패턴을 매핑할수 있음..
@WebServlet(name="HelloWorld", urlPatterns= {"/hello", "helloworld", "hello/world"})
public class HelloWorld extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("name");
		
		PrintWriter out = resp.getWriter();
		out.print(value + " :: Hello World!");
	}
}