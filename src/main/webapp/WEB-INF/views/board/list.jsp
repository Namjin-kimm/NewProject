<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
    <div class="container">
        <h1>List Page</h1>
            <table class="table table-hover" id="table" style="cursor: pointer;">
                <thead>
                    <tr>
                        <th>NUM</th><th>WRITER</th><th>TITLE</th><th>CONTENTS</th><th>HIT</th><th>REGDATE</th>
                        <th>REF</th><th>STEP</th><th>DEPTH</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="vo">
                        <tr>
                            <td>${vo.num}</td>
                            <td>${vo.writer}</td>
                            <td>${vo.title}</td>
                            <td>${vo.contents}</td>
                            <td>${vo.hit}</td>
                            <td>${vo.regDate}</td>
                            <td>${vo.ref}</td>
                            <td>${vo.step}</td>
                            <td>${vo.depth}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </div>

</body>
</html>