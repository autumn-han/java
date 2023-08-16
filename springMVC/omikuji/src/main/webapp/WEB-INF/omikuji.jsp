<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Here's Your Omikuji:</h1>
	<div>
		<p>In <c:out value="${number}" /> years, you will live in <c:out value="${city}" /> with <c:out value="${person}" /> as your roommate, <c:out value="${activity}" />.</p>
		<p>The next time you see a <c:out value="${animal}" />, you will have good luck.</p>
		<p>Also, <c:out value="${blurb}" /></p>
	</div>
	<a href="/omikuji">Go Back</a>
</body>
</html>