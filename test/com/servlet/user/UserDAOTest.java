package com.servlet.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


public class UserDAOTest {
	

	private UserDAO userDao;
	
	@Before
	public void setup() {
		userDao = new UserDAO();
		
	}
	
	@Test
	public void connection() throws Exception {
		Connection con = userDao.getConnection();
		assertNotNull(con);
	}

	@Test
	public void crud() throws Exception {
		User user = UserTest.TEST_USER;
		userDao.removeUser(user.getUserId());
		userDao.addUser(user);
		
		User dbUser = userDao.findByUserId(user.getUserId());
		assertEquals(user, dbUser);
		
		User updateUser = new User(user.getUserId(), "uPassword", "uName", "uEmail");
		userDao.updateUser(updateUser);
		dbUser = userDao.findByUserId(updateUser.getUserId());
		
		assertEquals(updateUser, dbUser);
		
	}
	
	@Test
	public void ��������_�ʴ�_�����_��ȸ() throws SQLException, Exception {
		User user = UserTest.TEST_USER;
		userDao.removeUser(user.getUserId());
		User dbUser = userDao.findByUserId(user.getUserId());
		assertNull(dbUser);
	}
	
}
