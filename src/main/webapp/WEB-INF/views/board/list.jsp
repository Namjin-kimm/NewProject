<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>List Page</h1>
        <section class="container col-lg-6" id="listSearchFrame">
		    <div class="d-flex">
                <form method="get" action="./list" class="d-flex justify-contents-center align-items-center">
                    
                    <label class="visually-hidden" for="select">Select</label>
                    <select name="select" class="form-select" id="select">
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="contents">내용</option>
                    </select>
                    
                    <label class="visually-hidden" for="search">Search</label>
                    <!-- 라벨의 for와 input의 id를 같게하면 같은 영역으로 인식되서 편리하다. -->
                    <div class="input-group" id="searchFrame">
                    <input type="text" class="form-control" id="search" name="search">
                    </div>
                    
                </form>
                <div>
                    <button type="submit" class="btn btn-primary">검색</button>
                </div>
		    </div>
	    </section>
           
        <section class="container-fluid col-10">
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
                            <td><a href="./detail?num=${vo.num}">${vo.num}</a></td>
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
        </section>

        <div class="container">
            <nav aria-label="Page navigation example" id="nav">
                <ul class="pagination">
                    <c:if test="${pager.pre}">
                        <li class="page-item">
                            <a class="page-link" href="./list?page=${pager.startNum - 1}&select=${pager.select}&search=${pager.search}">Previous</a>
                        </li>
                    </c:if>

                    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                        <li class="page-item">
                            <a class="page-link" href="./list?page=${i}&select=${pager.select}&search=${pager.search}">${i}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${pager.next}">
                        <li class="page-item">
                            <a class="page-link" href="./list?page=${pager.lastNum + 1}&select=${pager.select}&search=${pager.search}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>

</body>
</html>