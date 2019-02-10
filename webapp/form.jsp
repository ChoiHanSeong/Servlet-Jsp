<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>
	
<%@ include file="./commons/_header.jspf" %>
    
<h1>회원가입</h1>
<form action="/form_action.jsp" method="post">
	사용자 아이디 : <input name="userId"   type="text">
	비밀번호 :      <input name="password" type="password"> 
	이름 :          <input name="name"     type="text"> 
	이메일 :        <input name="email"    type="email"> 
	<input type="submit" value="회원가입">
</form>

</body>
</html>