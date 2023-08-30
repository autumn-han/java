<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1><c:out value="${product.name}" /></h1>
	<a href=""><button>Home</button></a>
	<div>
		<h3>Categories</h3>
		<ul>
			<c:forEach var="category" items="${categories}">
				<c:if test="${ product.id != category.product.id }">
					<li><c:out value="${category.name}" /></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
	<div>
		<h3>Add Categories:</h3>
		<form:form action="" method="post" modelAttribute="updateProduct">
			<div>
				<form:input path="id" value="${product.id}" type="hidden" />
				<form:input path="name" value="${product.name}" type="hidden" />
				<form:input path="description" value="${product.description}" type="hidden" />
				<form:input path="price" value="${product.price}" type="hidden" />
			</div>
			<div>
				<!-- add in the select dropdown menu here -->
			</div>
		</form:form>
	</div>
</body>
</html>