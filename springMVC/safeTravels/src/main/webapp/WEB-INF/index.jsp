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
	<h1>Safe Travels</h1>
	<!-- table to display all recorded expenses -->
	<div>
		<table>
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td><c:out value="${expense.name}" /></td>
						<td><c:out value="${expense.vendor}" /></td>
						<td>$<c:out value="${expense.amount}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- form for submitting a new expense -->
	<div>
		<form:form action="/new" method="post" modelAttribute="expense">
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
			<button>Add Expense</button>
		</form:form>
	</div>
</body>
</html>