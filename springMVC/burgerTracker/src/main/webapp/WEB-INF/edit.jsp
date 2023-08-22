<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1 class="m-3 w-25 pt-2 pb-2 text-center border border-warning rounded bg-warning text-light">Edit Burger</h1>
	<div class="m-3 p-3 border border-secondary rounded bg-secondary text-light" style="width:400px">
		<form:form action="/burger/edit/${burger.id}" method="post" modelAttribute="burger">
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