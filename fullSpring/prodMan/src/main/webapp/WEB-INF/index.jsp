<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Home Page</h1>
	<div>
		<a href="/products/new"><button>New Product</button></a>
		<a href="/categories/new"><button>New Category</button></a>
	</div>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="product" items="${products}">
						<td><a href=""><c:out value="${product.name}" /></a></td>
					</c:forEach>
					<c:forEach var="category" items="${categories}">				
						<td><a href=""><c:out value="${category.name}" /></a></td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>