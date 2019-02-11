package com.servlet.user;

import com.servlet.db.Database;

public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
	
	public User(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public boolean matchPassword(String dbPassword) {
		return dbPassword.equals(this.password);
	}

	public static boolean login(String userId, String password) throws UserNotFoundException, PasswordMismatchException {
		User dbUser = Database.findByUserId(userId);
		
		System.out.println("dbUser :: " + dbUser);
		
		if(dbUser == null) {
			throw new UserNotFoundException();
		}
		if (!dbUser.matchPassword(password)) {
			throw new PasswordMismatchException();
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
}
