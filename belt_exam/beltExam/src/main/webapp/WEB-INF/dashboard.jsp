<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yoga Course Manager</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<!-- header div -->
	<div class="d-flex justify-content-around mt-3">
		<div>
			<h1>Namaste, <c:out value="${user.name}" /></h1>
		</div>
		<div>
			<a href="/logout"><button class="btn btn-danger">Logout</button></a>
			<a href="/classes/new"><button class="btn btn-primary">Add Course</button></a>
		</div>
	</div>
	<!-- table with all users and users' books -->
	<div class="mx-auto mt-5" style="width: 1050px;">
		<h3>Course Schedule</h3>
		<table class="table">
			<thead class="table-success">
				<tr>
					
					<th>Class Name</th>
					<th>Instructor</th>
					<th>Weekday</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">							
					<tr>
						<td>
							<a href="/classes/${course.id}"><c:out value="${course.name}" /></a>
							<c:if test="${ user.id == course.user.id }">
								<a href="/classes/${course.id}/edit"><button>Edit</button></a>
							</c:if>
						</td>
						<td><c:out value="${course.user.name}" /></td>
						<td><c:out value="${course.day}" /></td>
						<td><c:out value="${course.price}" />
					</tr>		
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>