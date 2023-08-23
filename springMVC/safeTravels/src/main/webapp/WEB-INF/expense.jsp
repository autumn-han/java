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
	<div class="d-flex justify-content-evenly m-3">
		<h1 class="w-25 border border-primary rounded bg-primary text-light text-center">Expense Details</h1>
		<a href="/">Go Back</a>
	</div>
	<div class="w-50 mx-auto">
		<table class="table">
			<tr>
				<td class="fw-bold">Expense: </td>
				<td><c:out value="${expense.name}" /></td>
			</tr>
			<tr>
				<td class="fw-bold">Description: </td>
				<td><c:out value="${expense.description}" /></td>
			</tr>
			<tr>
				<td class="fw-bold">Vendor: </td>
				<td><c:out value="${expense.vendor}" /></td>
			</tr>
			<tr>
				<td class="fw-bold">Amount Spent: </td>
				<td>$<c:out value="${expense.amount}" /></td>
			</tr>
		</table>
	</div>
</body>
</html>