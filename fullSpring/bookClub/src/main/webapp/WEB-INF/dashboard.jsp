<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<!-- header div -->
	<div class="d-flex justify-content-around mt-3">
		<div>
			<h3>Hello, <c:out value="${user.name}" />. Welcome to...</h3>
			<h1>The Book Broker</h1>
		</div>
		<div>
			<a href="/logout"><button class="btn btn-danger">Logout</button></a>
			<a href="/books/new"><button class="btn btn-primary">Add a Book to My Shelf</button></a>
		</div>
	</div>
	<!-- table with all users and users' books -->
	<div class="mx-auto mt-5" style="width: 1050px;">
		<h3>All Books</h3>
		<table class="table">
			<thead class="table-success">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Posted By</th>
					<th>Status</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<c:if test="${ user.id != book.borrower.id }">				
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><a href="/book/${book.id}"><c:out value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<c:if test="${ user.id == book.user.id }">
								<td>You</td>
							</c:if>
							<c:if test="${ user.id != book.user.id }">
								<td><c:out value="${book.user.name}" /></td>
							</c:if>
							<c:if test="${ book.borrower != null }">
								<td>Checked Out</td>
							</c:if>
							<c:if test="${ book.borrower == null }">
								<td>Available</td>
							</c:if>
							<c:if test="${ user.id == book.user.id }">
								<td>
									<div class="d-flex justify-content-between" style="width: 150px;">
										<a href="/books/edit/${book.id}"><button class="btn btn-warning">Edit</button></a>
										<form action="/delete/${book.id}" method="post">
											<input type="hidden" value="delete" />
											<button class="btn btn-danger">Delete</button>
										</form>
									</div>
								</td>
							</c:if>
							<c:if test="${ user.id != book.user.id }">
								<c:if test="${ book.borrower != null }">
									<td></td>
								</c:if>
								<c:if test="${ book.borrower == null }">
									<td>
										<form:form action="/borrow/${book.id}" method="post" modelAttribute="borrowed">
											<form:input path="user" type="hidden" value="${book.user.id}" />
											<form:input path="borrower" type="hidden" value="${user.id}" />
											<form:input path="title" type="hidden" value="${book.title}" />
											<form:input path="author" type="hidden" value="${book.author}" />
											<form:input path="comments" type="hidden" value="${book.comments}" />
											<button class="btn btn-success">Borrow</button>
										</form:form>
									</td>
								</c:if>
							</c:if>
						</tr>
					</c:if>			
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- table with all the logged in users currently borrowed books -->
	 <div class="mx-auto mt-5" style="width: 1050px;">
	 	<h3>Books I'm Borrowing</h3>
		<table class="table">
			<thead class="table-warning">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Posted By</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<c:if test="${ user.id == book.borrower.id }">
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><a href="/book/${book.id}"><c:out value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.name}" /></td>
							<td>
								<form:form action="/return/${book.id}" method="post" modelAttribute="returned">
									<form:input path="user" type="hidden" value="${book.user.id}" />
									<form:input path="title" type="hidden" value="${book.title}" />
									<form:input path="author" type="hidden" value="${book.author}" />
									<form:input path="comments" type="hidden" value="${book.comments}" />
									<button class="btn btn-success">Return</button>
								</form:form>
							</td>
						</tr>
					</c:if>				
				</c:forEach>
			</tbody>
		</table>
	</div> 
</body>
</html>