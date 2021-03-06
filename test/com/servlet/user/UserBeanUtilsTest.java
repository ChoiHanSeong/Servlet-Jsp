package com.servlet.user;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Test;

public class UserBeanUtilsTest {

	@Test
	public void populate() throws Exception {
		final Map<String, String[]> params = new HashMap<>();
		params.put("userName", new String[]{"userA"});
		params.put("password", new String[]{"secrect"});
		params.put("id", new String[]{"10"});
		final JavaBean javaBean = new JavaBean();
		BeanUtilsBean.getInstance().populate(javaBean, params);
		
		System.out.println(javaBean.getUserName());
		System.out.println(javaBean.getPassword());
		System.out.println(javaBean.getId());
		
	}

}
