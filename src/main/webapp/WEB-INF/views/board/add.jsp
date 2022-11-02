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
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/add.js"></script>
<script defer src="/js/util.js"></script>
</head>
<body>
	<h1>Add Page</h1>
	
	<div class="container col-lg-6">
		<form:form method="POST" modelAttribute="boardVO" enctype="multipart/form-data" id="form">
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<form:input path="writer" cssClass="form-control" id="writer" placeholder="Writer" />
				<div id="writerm" style="color: red;"></div>
				<div id="writerm2" style="color: blue;"></div>
				<form:errors path="writer"></form:errors>
			</div>
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<form:input path="title" cssClass="form-control" id="title" placeholder="Title" />
				<div id="titlem" style="color: red;"></div>
				<div id="titlem2" style="color: blue;"></div>
				<form:errors path="title"></form:errors>
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<form:textarea path="contents" id="contents"></form:textarea>
				<div id="contentsm" style="color: red;"></div>
				<div id="contentsm2" style="color: blue;"></div>
				<form:errors path="contents"></form:errors>
			</div>
			
			<div>
				<button type="button" id="fileAdd" class="btn btn-primary">파일추가</button>
			</div>
			
			<div id="fileList"></div>
			
		</form:form>
		<div class="d-flex" style="flex-direction: row-reverse">
			<button type="button" id="submitBtn" class="btn btn-primary">Submit</button>
		</div>
	</div>

	<script type="java/template" id="fileAddForm">
		<div class="mb-3">
			<label for="files" class="form-label">Files</label>
			<input type="file" name="files">
			<button type="button" class="del btn btn-danger">삭제</button>
		</div>
	</script>

<script type="text/javascript">
	$("#contents").summernote({
		height: 300,
		placeholder: 'Contents'
	});
</script>
</body>
</html>