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
<form action="/users/save" method="post">
	사용자 아이디 : <input name="userId"   type="text"><br/>
	비밀번호 :      <input name="password" type="password"><br/> 
	이름 :          <input name="name"     type="text"><br/>
	이메일 :        <input name="email"    type="email"><br/>
	<input type="submit" value="회원가입">
</form>

</body>
</html>