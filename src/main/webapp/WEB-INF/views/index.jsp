<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Index page</h1>
	<a type="button" class="btn btn-primary" href="/board/list">리스트</a>
	
	<sec:authorize access="isAuthenticated()">
		<a href="/member/logout" type="button" class="btn btn-danger">로그아웃</a>
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="/member/login" type="button" class="btn btn-primary">로그인</a>
		<a href="/member/join" type="button" class="btn btn-primary">회원가입</a>
	</sec:authorize>

</body>
</html>