package com.servlet.db;

import java.util.HashMap;
import java.util.Map;

import com.servlet.user.User;

public class Database {
	
	private static Map<String, User> users = new HashMap<String, User>();
	
	public static void addUser(User user) {
		System.out.println("DB User user :: " + user);
		users.put(user.getUserId(), user);
	}
	
}
