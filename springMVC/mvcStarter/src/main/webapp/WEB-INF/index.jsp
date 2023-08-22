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
		<h1>All Books</h1>
	</div>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>		
					<th>Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}" /></a></td>
						<td><c:out value="${book.pages}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

<!-- 1. property not found error when I try to pull the 'language' attribute from the object - checked model file but spelling seems to be fine -->