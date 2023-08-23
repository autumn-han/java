<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<h1 class="w-25 m-3 border border-primary rounded bg-primary text-light text-center">Edit Expense</h1>
		<a href="/" class="m-3">Go Back</a>
	</div>
	<div class="w-25 m-3 p-3 border bg-secondary bg-gradient rounded text-light">
		<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
			<!-- displaying validation errors at the top of the form -->
			<div class="rounded bg-light text-center text-danger">
				<form:errors path="name" />
				<form:errors path="vendor" />
				<form:errors path="amount" />
			</div>
			<div>
				<form:label path="name" class="form-label">Expense Name: </form:label>
				<form:input path="name" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="vendor" class="form-label">Vendor: </form:label>
				<form:input path="vendor" type="text" class="form-control" />
			</div>
			<div>
				<form:label path="amount" class="form-label">Amount: $</form:label>
				<form:input path="amount" type="number" class="form-control" />
			</div>
			<div>
				<form:label path="description" class="form-label">Description: </form:label>
				<form:textarea path="description" placeholder="Optional" class="form-control"></form:textarea>
			</div>
			<button class="btn btn-success mt-3">Edit Expense</button>
		</form:form>
	</div>
</body>
</html>