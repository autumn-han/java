<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<h1>Change Entry</h1>
		<a href="/books"><button>Back to the Shelves</button></a>
	</div>
	<div>
		<form:form action="/books/edit/${book.id}" method="post" modelAttribute="bookEdit">
			<div>
				<p><form:errors path="title" /></p>
				<p><form:errors path="author" /></p>
				<p><form:errors path="comments" /></p>
			</div>
			<div>
				<form:input path="borrower" type="hidden" value="${book.borrower.id}" />
				<form:input path="user" type="hidden" value="${book.user.id}"/>
			</div>
			<div>
				<form:label path="title">Title: </form:label>
				<form:input path="title" />
			</div>
			<div>
				<form:label path="author">Author: </form:label>
				<form:input path="author" />
			</div>
			<div>
				<form:label path="comments">Comments: </form:label>
				<form:textarea path="comments"/>
			</div>
			<button>Submit Edit</button>
		</form:form>
	</div>
	<div>
		<form action="/delete/${book.id}" method="post">
			<input type="hidden" value="delete" />
			<button>Delete</button>
		</form>
	</div>
</body>
</html>