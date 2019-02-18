<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>
	
<%@ include file="./commons/_header.jspf" %>
<c:choose>
	<c:when test="${empty user.userId}">
<h1>회원가입</h1>		
	</c:when>
	<c:otherwise>
<h1>개인정보수정</h1>
	</c:otherwise>
</c:choose>

	<c:set var="actionUrl" value="/users/create" />
	<c:if test="${not empty user.userId}">
		<c:set var="actionUrl" value="/users/update" />
	</c:if>

<form action="${actionUrl}" method="post">
<c:if test="${not empty errorMessage}">
	<h1>${errorMessage}</h1>
</c:if>
<c:choose>
	<c:when test="${empty user.userId}">		
	사용자 아이디 : <input name="userId"   type="text" value="${user.userId}"><br/>
	</c:when>
	<c:otherwise>
	<input type="hidden" name="userId" value="${user.userId}">
	사용자 아이디 : ${user.userId}<br/>
	</c:otherwise>
</c:choose>
	비밀번호 :      <input name="password" type="password" value="${user.password}"><br/> 
	이름 :          <input name="name"     type="text" value="${user.name}"><br/> 
	이메일 :        <input name="email"    type="email" value="${user.email}"><br/>
	<c:set var="actionSubmitValue" value="회원가입" />
	<c:if test="${not empty user.userId}">
		<c:set var="actionSubmitValue" value="수정" />
	</c:if>
	<input type="submit" value="${actionSubmitValue}">
</form>

</body>
</html>