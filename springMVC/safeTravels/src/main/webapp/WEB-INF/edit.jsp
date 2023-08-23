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
		<h1>Edit Expense</h1>
		<a href="/">Go Back</a>
	</div>
	<div>
		<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
			<!-- displaying validation errors at the top of the form -->
			<div>
				<form:errors path="name" />
				<form:errors path="vendor" />
				<form:errors path="amount" />
			</div>
			<div>
				<form:label path="name">Expense Name: </form:label>
				<form:input path="name" type="text" />
			</div>
			<div>
				<form:label path="vendor">Vendor: </form:label>
				<form:input path="vendor" type="text" />
			</div>
			<div>
				<form:label path="amount">Amount: $</form:label>
				<form:input path="amount" type="number" />
			</div>
			<div>
				<form:label path="description">Description: </form:label>
				<form:textarea path="description" placeholder="Optional"></form:textarea>
			</div>
			<button>Edit Expense</button>
		</form:form>
	</div>
</body>
</html>