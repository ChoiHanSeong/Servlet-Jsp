<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>
	
	<div>
        <ul>
            <li><a href="">홈</a></li>
            <li><a href="">로그인</a></li>
            <li><a href="/form.jsp">회원가입</a></li>
            <li><a href="">로그아웃</a></li>
            <li><a href="">개인정보수정</a></li>
        </ul>
    </div>
    
<h1>회원가입</h1>
<form id="login-form" method="post">
	사용자 아이디 : <input name="userid" type="text">
	비밀번호 : <input name="passwprd" type="password"> 
	<input type="submit" value="회원가입">
</form>

</body>
</html>