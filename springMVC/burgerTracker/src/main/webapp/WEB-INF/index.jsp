<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- check this uri, if the server breaks -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="m-3 w-25 pt-2 pb-2 text-center border border-warning rounded bg-warning text-light">Burger Tracker</h1>
	<div class="w-75 m-3">
	<!-- display all burgers in table -->
		<table class="table">
			<thead>
				<tr class="table-primary">
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
	<div class="m-5 p-3 border border-secondary rounded bg-secondary text-light" style="width:400px">
	<!-- implementing form:form jstl tags for this project -->
		<h2 class="m-3 w-75 pt-2 pb-2 mx-auto text-center border border-primary rounded bg-primary text-light">Add Burger</h2>
		<form:form action="/new" method="post" modelAttribute="burger">
			<div>
				<form:label path="name" class="form-label">Burger Name: </form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="restaurant" class="form-label">Restaurant Name: </form:label>
				<form:errors path="restaurant" class="text-danger" />
				<form:input path="restaurant" type="text" class="form-control" />
			</div>		
			<div>
				<form:label path="rating" class="form-label">Rating: </form:label>
				<form:errors path="rating" class="text-danger" />
				<form:input path="rating" type="number" min="1" max="5" class="form-control" />
			</div>
			<div>
				<form:label path="notes" class="form-label">Notes: </form:label>
				<form:textarea path="notes" rows="10" style="width:280px" placeholder="Optional" class="form-control"></form:textarea>
			</div>
			<button class="btn btn-success mt-3">Buns Away</button>
		</form:form>
	</div>
</body>
</html>