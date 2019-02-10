package com.servlet.db;


import static org.junit.Assert.*;

import org.junit.Test;

import com.servlet.user.User;
import com.servlet.user.UserTest;

public class DatabaseTest {

	@Test
	public void addAndFind() {
		User user = UserTest.TEST_USER;
		Database.addUser(user);
		
		User dbUser = Database.findByUserId(user.getUserId());
		assertEquals(user, dbUser);
		
	}

}
