package com.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionUserId = SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		if(sessionUserId == null) {
			response.sendRedirect("/");
			return;
		}
		
		String userId   = request.getParameter("userId");
		// �α��� ����ڿ�, ���� �Ϸ��� ����� id�� ������..
		if(!sessionUserId.equals(userId)) {
			response.sendRedirect("/");
			return;
		}
		
		String password = request.getParameter("password");
		String name     = request.getParameter("name");
		String email    = request.getParameter("email");
		
		User user = new User(userId, password, name, email);
		UserDAO userDao = new UserDAO();
		try {
			userDao.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/");
		
	}
	
}
