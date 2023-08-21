<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<h1><c:out value="${title}" /></h1>
		<p>Description: <c:out value="${desc}" /></p>
		<p>Language: <c:out value="${lang}" /></p>
		<p>Number of Pages: <c:out value="${pages}" /></p>
	</div>
</body>
</html>