<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="d-flex mx-auto justify-content-between mt-3" style="width: 1000px;">
		<h1>Add a Book to Your Shelf</h1>
		<a href="/books"><button class="btn btn-primary">Back to the Shelves</button></a>
	</div>
	<div class="mx-auto mt-3" style="width: 1000px;">
		<form:form action="/books/new" method="post" modelAttribute="newBook" class="w-50">
			<div>
				<p><form:errors path="title" /></p>
				<p><form:errors path="author" /></p>
				<p><form:errors path="comments" /></p>
			</div>
			<div>
				<form:input path="user" type="hidden" value="${user.id}"/>
			</div>
			<div>
				<form:label path="title" class="form-label">Title: </form:label>
				<form:input path="title" class="form-control"/>
			</div>
			<div>
				<form:label path="author" class="form-label">Author: </form:label>
				<form:input path="author" class="form-control"/>
			</div>
			<div>
				<form:label path="comments" class="form-label">Comments: </form:label>
				<form:textarea path="comments" class="form-control"/>
			</div>
			<button class="btn btn-success mt-3">Add Book to Shelf</button>
		</form:form>
	</div>
</body>
</html>