<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>
	
<%@ include file="./commons/_header.jspf" %>
    
<h1>로그인</h1>

<form action="/users/login" method="post">
	<c:if test="${not empty errorMessage}">
		<h1>${errorMessage}</h1>
	</c:if>

	사용자 아이디 : <input name="userId"   type="text">
	비밀번호 :      <input name="password" type="password"> 
	<input type="submit" value="로그인">
</form>

</body>
</html>