package com.servlet.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ������̼��� �̿��ؼ� �������� url ������ �����Ҽ� ����..
@WebServlet(
	name = "MyOwnServlet",
	description = "This is my first annotated servlet",
	urlPatterns = {"/hello", "/hello2", "/hello3"}
)
public class HelloWorld extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("HelloWorld class Call...");
		
		String value = req.getParameter("name");
		
		PrintWriter out = resp.getWriter();
		out.print(value + " :: Hello World!");
	}
}