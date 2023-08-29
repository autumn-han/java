<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<!-- header div -->
	<div>
		<div>
			<h1>Welcome, <c:out value="${user.name}" /></h1>
		</div>
		<div>
			<a href="/logout"><button>Logout</button></a>
			<a href="/books/new"><button>Add a Book to My Shelf</button></a>
		</div>
	</div>
	<!-- table with all users and users' books -->
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="/book/${book.id}"><c:out value="${book.title}" /></a></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.user.name}" /></td>
					</tr>				
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>