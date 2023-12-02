<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Information</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="d-flex mx-auto justify-content-between mt-3" style="width: 1000px;">
		<h1><c:out value="${course.name}" /> with <c:out value="${course.user.name}" /></h1>
		<a href="/classes"><button class="btn btn-primary">Return to Dashboard</button></a>
	</div>
	<div class="mx-auto mt-3" style="width: 1000px;">
		<h4>Day: <c:out value="${course.day}" /></h4>
		<h4>Cost: $<c:out value="${course.price}" /></h4>
	</div>
	<div class="mx-auto mt-3" style="width: 1000px;">
		<p><c:out value="${course.description}" /></p>
	</div>
</body>
</html>