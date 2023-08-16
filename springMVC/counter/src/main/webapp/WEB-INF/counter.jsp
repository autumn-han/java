<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>
</head>
<body>
	<h1>You have visited your server: <c:out value="${count}" /> time(s)</h1>
	<a href="/your_server">Test Another Visit?</a>
</body>
</html>