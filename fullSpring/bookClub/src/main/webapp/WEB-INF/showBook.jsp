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
	<div>
		<h1><c:out value="${book.title}" /></h1>
		<a href="/books"><button>Back to the Shelves</button></a>
	</div>
	<div>
		<c:if test="${ book.user.id == user.id }">
			<h4>You read <c:out value="${book.title}" /> by <c:out value="${book.author}" />.</h4>
			<h4>Here are some of your thoughts: </h4>
		</c:if>
		<c:if test="${ book.user.id != user.id }">
			<h4><c:out value="${book.user.name}" /> read <c:out value="${book.title}" /> by <c:out value="${book.author}" />.</h4>
			<h4>Here are some of <c:out value="${book.user.name}" />'s thoughts: </h4>
		</c:if>
	</div>
	<div>
		<p><c:out value="${book.comments}" /></p>
	</div>
	<c:if test="${ book.user.id == user.id }">
		<div class="d-flex">
			<a href="/books/edit/${book.id}"><button>Edit</button></a>
			<form action="/delete/${book.id}" method="post">
				<input type="hidden" value="delete" />
				<button>Delete</button>
			</form>
		</div>
	</c:if>
</body>
</html>