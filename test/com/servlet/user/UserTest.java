package com.servlet.user;

import static org.junit.Assert.*;

import org.junit.Test;

import com.servlet.db.Database;

public class UserTest {

	public static User TEST_USER = new User("userId", "password", "name", "email");
	
	@Test
	public void ��й�ȣ��ġ() {
		boolean result = TEST_USER.matchPassword("password");
		assertTrue(result);
	}

	@Test
	public void ��й�ȣ����ġ() {
		boolean result = TEST_USER.matchPassword("password2");
		assertFalse(result);
	}

	@Test
	public void �α��μ���() throws Exception {
		User user = UserTest.TEST_USER;
		UserDAO userDao = new UserDAO();
		userDao.addUser(user);
		User.login(TEST_USER.getUserId(), TEST_USER.getPassword());
	}
	
	@Test
	public void ����ھ���() throws Exception {
		User user = UserTest.TEST_USER;
		UserDAO userDao = new UserDAO();
		userDao.addUser(user);
		User.login(TEST_USER.getUserId(), TEST_USER.getPassword());
	}
	
	@Test(expected=UserNotFoundException.class)
	public void loginWhenUserIdNotExist() throws Exception {
		User.login("userId2", TEST_USER.getPassword());
	}
	
	@Test(expected=PasswordMismatchException.class)
	public void loginWhenPasswordMismatch() throws Exception {
		User user = UserTest.TEST_USER;
		UserDAO userDao = new UserDAO();
		userDao.addUser(user);
		
		User.login(TEST_USER.getUserId(), "missmatch");
	}
}
