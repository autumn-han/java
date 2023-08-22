<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Burger Tracker</h1>
	<div>
	<!-- display all burgers in table -->
		<table>
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (1-5)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgers}">
					<tr>
						<td><c:out value="${burger.name}" /></td>
						<td><c:out value="${burger.restaurant}" /></td>
						<td><c:out value="${burger.rating}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<form>
			<div>
				<label>Burger Name: </label>
				<input name="name" type="text" />
			</div>
			<div>
				<label>Restaurant Name: </label>
				<input name="restaurant" type="text" />
			</div>		
			<div>
				<label>Rating: </label>
				<input name="rating" type="number" min="1" max="5" />
			</div>
			<div>
				<label>Notes: </label>
				<textarea name="notes"></textarea>
			</div>
			<button>Buns Away</button>
		</form>
	</div>
</body>
</html>