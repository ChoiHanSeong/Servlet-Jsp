package com.servlet.user;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pathTest extends HttpServlet {
	
	public static void main(String[] args) throws IOException {
		
		// ��� Ȯ��.
		File testpath = new File(".");
		System.out.println(testpath.getAbsolutePath());
		String path = pathTest.class.getResource("").getPath();
		System.out.println(path);

		UserDAO userDao = new UserDAO();
		/*===========================================================================
		// �⺻��Ű������ ���ҽ� ��������
		===========================================================================*/
		File filePath = new File(userDao.getClass().getResource("/excludedir.properties").getFile());
		InputStream infile = userDao.getClass().getResourceAsStream("/excludedir.properties");
		
		/*===========================================================================
		// Ư�� ��Ű������ ���ҽ� ��������
		===========================================================================*/
		File f = new File(userDao.getClass().getResource("/main/resources/db.properties").getFile());
		InputStream in = userDao.getClass().getResourceAsStream("/main/resources/db.properties");
		
		Properties properties = new Properties();
		properties.load(in);
		
		String url = properties.getProperty("url");
		String id = properties.getProperty("id");
		String pw = properties.getProperty("pw");

		System.out.println("url :: " + url + " / " + "id :: " + id + " / " + "pw :: " + pw);


	}

}
