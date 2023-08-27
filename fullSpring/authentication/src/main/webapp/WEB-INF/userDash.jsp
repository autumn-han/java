<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.user_name}" /></h1>
	<h3>This is your dashboard - nothing to see here yet...</h3>
	<a href="/user/logout"><button>Logout</button></a>
</body>
</html>