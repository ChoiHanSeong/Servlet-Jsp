<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>

<body>

<%@ include file="./commons/_header.jspf" %>
    
<h1>개인정보수정</h1>
<form action="/users/update" method="post">
	<input type="hidden" name="userId" value="${user.userId}">
	사용자 아이디 : ${user.userId}<br/>
	비밀번호 :      <input name="password" type="password" value="${user.password}"><br/> 
	이름 :          <input name="name"     type="text" value="${user.name}"><br/> 
	이메일 :        <input name="email"    type="email" value="${user.email}"><br/> 
	<input type="submit" value="수정"><br/>
</form>

</body>
</html>