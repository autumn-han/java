<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add A Course</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="d-flex mx-auto justify-content-between mt-3" style="width: 1000px;">
		<h1>Create a Course</h1>
		<a href="/classes"><button class="btn btn-danger">Cancel</button></a>
	</div>
	<div class="mx-auto mt-3" style="width: 1000px;">
		<form:form action="/classes/new" method="post" modelAttribute="newCourse" class="w-50">
			<div>
				<p><form:errors path="name" /></p>
				<p><form:errors path="day" /></p>
				<p><form:errors path="price" /></p>
				<p><form:errors path="description" /></p>
			</div>
			<div>
				<form:input path="user" type="hidden" value="${user.id}"/>
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
			<button class="btn btn-success mt-3">Add</button>
		</form:form>
	</div>
</body>
</html>