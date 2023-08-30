<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Product</h1>
	<a href="/"><button>Home</button></a>
	<div>
		<form:form action="/products/new" method="post" modelAttribute="product">
			<div>
				<form:label path="name">Name: </form:label>
				<form:input path="name" />
			</div>
			<div>
				<form:label path="description">Description: </form:label>
				<form:input path="description" />
			</div>
			<div>
				<form:label path="price">Price: </form:label>
				<form:input path="price" type="number" />
			</div>
			<button>Add Product</button>
		</form:form>
	</div>
</body>
</html>