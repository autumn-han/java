<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="d-flex mx-auto justify-content-between mt-3" style="width: 1000px;">
		<h1><c:out value="${course.name}" /></h1>
		<a href="/classes"><button class="btn btn-danger">Cancel</button></a>
	</div>
	<div class="mx-auto mt-3" style="width: 1000px;">
		<form:form action="/classes/${course.id}/edit" method="post" modelAttribute="courseEdit" class="w-50">
			<div>
				<p><form:errors path="name" /></p>
				<p><form:errors path="day" /></p>
				<p><form:errors path="price" /></p>
				<p><form:errors path="description" /></p>
			</div>
			<div>
				<form:input path="user" type="hidden" value="${course.user.id}"/>
			</div>
			<div>
				<form:label path="name" class="form-label">Name: </form:label>
				<form:input path="name" class="form-control"/>
			</div>
			<div>
				<form:label path="day" class="form-label">Day of Week: </form:label>
				<form:input path="day" class="form-control"/>
			</div>
			<div>
				<form:label path="price" class="form-label">Price: </form:label>
				<form:input path="price" type="number" class="form-control" />
			</div>
			<div>
				<form:label path="description" class="form-label">Description: </form:label>
				<form:textarea path="description" class="form-control"/>
			</div>
			<button class="btn btn-success mt-3">Edit</button>
		</form:form>
	</div>
	<div class="mx-auto mt-3" style="width: 1000px;">
		<form action="/delete/${course.id}" method="post">
			<input type="hidden" value="delete" />
			<button class="btn btn-danger">Delete</button>
		</form>
	</div>
</body>
</html>