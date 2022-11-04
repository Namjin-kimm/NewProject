<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/join.js"></script>
<script defer src="/js/util.js"></script>
</head>
<body>
	<form:form modelAttribute="memberVO" method="post">
		<div class="container col-lg-6">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<form:input path="id" cssClass="form-control" id="id" />
				<!-- <input type="text" class="form-control" id="id" aria-describedby="emailHelp" placeholder="ID" name="id"> -->
				<div id="idm" style="color: red;">
					<form:errors path="id"></form:errors>
				</div>
				<div id="idm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<form:password path="pw" cssClass="form-control" id="pw"/>
				<!-- <input type="text" class="form-control" id="pw" aria-describedby="emailHelp" placeholder="PW" name="pw"> -->
				<div id="pwm" style="color: red;">
					<form:errors path="pw"></form:errors>
				</div>
				<div id="pwm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="pwCheck" class="form-label">PW 확인</label>
				<form:password path="pwCheck" cssClass="form-control" id="pwCheck"/>
				<!-- <input type="text" class="form-control" id="pwCheck" aria-describedby="emailHelp" placeholder="PW Check"> -->
				<div id="pwCheckm" style="color: red;">
					<form:errors path="pwCheck"></form:errors>
				</div>
				<div id="pwCheckm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<form:input path="name" cssClass="form-control" id="name"/>
				<!-- <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="NAME" name="name"> -->
				<div id="namem" style="color: red;">
					<form:errors path="name"></form:errors>
				</div>
				<div id="namem2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<form:input path="email" cssClass="form-control" id="email"/>
				<!-- <input type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="EMAIL" name="email"> -->
				<div id="emailm" style="color: red;">
					<form:errors path="email"></form:errors>
				</div>
				<div id="emailm2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="age" class="form-label">AGE</label>
				<form:input path="age" cssClass="form-control" id="age"/>
				<!-- <input type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="EMAIL" name="email"> -->
				<div id="agem" style="color: red;">
					<form:errors path="age"></form:errors>
				</div>
				<div id="agem2" style="color: blue;"></div>
			</div>
			<div class="mb-3">
				<label for="birth" class="form-label">BIRTH</label>
				<form:input path="birth" cssClass="form-control" id="birth"/>
				<!-- <input type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="EMAIL" name="email"> -->
				<div id="birthm" style="color: red;">
					<form:errors path="birth"></form:errors>
				</div>
				<div id="birthm2" style="color: blue;"></div>
			</div>
			<button type="submit" id="joinButton" class="btn btn-primary">JOIN</button>
		</div>
	</form:form>

</body>
</html>