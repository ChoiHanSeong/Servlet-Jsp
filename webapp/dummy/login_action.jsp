<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.servlet.user.UserNotFoundException"%>
<%@ page import="com.servlet.user.User" %>
<%@ page import="com.servlet.db.Database" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="com.servlet.user.PasswordMismatchException"%>

<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	
	try {
		
		User.login(userId, password);
		session.setAttribute("userId", userId);
		response.sendRedirect("/");
		
	} catch (UserNotFoundException e) {
		
		request.setAttribute("errorMessage", "존재하지 않는 사용자 입니다. 다시 로그인하세요.");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	} catch (PasswordMismatchException e) {
		
		request.setAttribute("errorMessage", "비밀번호가 틀립니다. 다시 로그인하세요.");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
	
%>