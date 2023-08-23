<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Safe Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="w-25 m-3 border border-primary rounded bg-primary text-light text-center">Safe Travels</h1>
	<!-- table to display all recorded expenses -->
	<div class="w-50">
		<table class="table m-3">
			<thead class="table-secondary">
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th class="text-center">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}" /></a></td>
						<td><c:out value="${expense.vendor}" /></td>
						<td>$<c:out value="${expense.amount}" /></td>
						<td class="d-flex justify-content-evenly">
							<a href="/expenses/edit/${expense.id}"><button class="btn btn-warning">edit</button></a>
							<form action="/delete/${expense.id}" method="post">
								<input type="hidden" value="delete" />
								<button class="btn btn-danger">delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- form for submitting a new expense -->
	<div class="w-25 m-3 p-3 border bg-secondary bg-gradient rounded text-light">
		<h2 class="w-75 mx-auto border border-primary rounded bg-primary text-center">Add An Expense</h2>
		<form:form action="/new" method="post" modelAttribute="expense">
			<!-- displaying validation errors at the top of the form -->
			<div class="rounded bg-light text-center text-danger">
				<p><form:errors path="name" /></p>
				<p><form:errors path="vendor" /></p>
				<p><form:errors path="amount" /></p>
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
			<button class="btn btn-success mt-3">Add Expense</button>
		</form:form>
	</div>
</body>
</html>