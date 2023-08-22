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
	<!-- implementing form:form jstl tags for this project -->
		<form:form action="/new" method="post" modelAttribute="burger">
			<div>
				<form:label path="name">Burger Name: </form:label>
				<form:errors path="name" />
				<form:input path="name" type="text" />
			</div>
			<div>
				<form:label path="restaurant">Restaurant Name: </form:label>
				<form:errors path="restaurant" />
				<form:input path="restaurant" type="text" />
			</div>		
			<div>
				<form:label path="rating">Rating: </form:label>
				<form:errors path="rating" />
				<form:input path="rating" type="number" min="1" max="5" />
			</div>
			<div>
				<form:label path="notes">Notes: </form:label>
				<form:textarea path="notes" rows="10" style="width:280px" placeholder="Optional"></form:textarea>
			</div>
			<button>Buns Away</button>
		</form:form>
	</div>
</body>
</html>