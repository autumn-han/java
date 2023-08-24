<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojo/new" method="post" modelAttribute="dojo">
		<form:label path="name">Name: </form:label>
		<form:input path="name" />
		<button>Create</button>
	</form:form>
</body>
</html>