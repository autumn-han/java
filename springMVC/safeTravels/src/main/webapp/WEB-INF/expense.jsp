<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<h1>Expense Details</h1>
		<a href="/">Go Back</a>
	</div>
	<div>
		<table>
			<tr>
				<td>Expense: </td>
				<td><c:out value="${expense.name}" /></td>
			</tr>
			<tr>
				<td>Description: </td>
				<td><c:out value="${expense.description}" /></td>
			</tr>
			<tr>
				<td>Vendor: </td>
				<td><c:out value="${expense.vendor}" /></td>
			</tr>
			<tr>
				<td>Amount Spent: </td>
				<td>$<c:out value="${expense.amount}" /></td>
			</tr>
		</table>
	</div>
</body>
</html>