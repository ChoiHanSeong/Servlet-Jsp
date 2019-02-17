package com.servlet.user;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserDAO {
	
	public Connection getConnection() throws Exception {
		
		String propertiPath = "/main/resources/db.properties";
		InputStream in = this.getClass().getResourceAsStream(propertiPath);
		
		Properties properties = new Properties();
		properties.load(in);
		
		String url = properties.getProperty("url");
		String id  = properties.getProperty("id");
		String pw  = properties.getProperty("pw");
		
		System.out.println("url :: " + url + " / " + "id :: " + id + " / " + "pw :: " + pw);
		
		Class.forName(properties.getProperty("driver"));
		return DriverManager.getConnection(url, id, pw);
		
	}

	public void addUser(User user) throws Exception {
		String sql = "insert into USERS values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
	}

	public User findByUserId(String userId) throws SQLException, Exception {
		String sql = "select * from USERS WHERE userId = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			// 조회결과
			rs = pstmt.executeQuery();
			
			// 예외처리를 먼저하는것이 좋음
			if(!rs.next()) return null;
			
			return new User(rs.getString("userId")
					, rs.getString("password")
					, rs.getString("name")
					, rs.getString("email"));
			
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			if(rs != null) rs.close();
		}
	}
	
	public void removeUser(String userId) throws SQLException, Exception {
		String sql = "delete from USERS where userId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
	}

	public void updateUser(User user) throws SQLException, Exception {
		String sql = "update USERS set password = ?, name = ?, email = ? where userId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserId());
			
			pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
	}
	
}
