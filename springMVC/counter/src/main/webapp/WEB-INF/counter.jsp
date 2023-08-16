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
	<p><a href="/your_server">Test another visit to the welcome page?</a></p>
	<p><a href="/your_server/count_by_two">Want to increase the count by two?</a></p>
	<p><a href="/reset"><button>Clear Count</button></a></p>
</body>
</html>