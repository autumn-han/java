<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Category</h1>
	<a href="/"><button>Home</button></a>
	<div>
		<form:form action="/categories/new" method="post" modelAttribute="category">
			<div>
				<form:label path="name">Name: </form:label>
				<form:input path="name" />
			</div>
			<button>Add Category</button>
		</form:form>
	</div>
</body>
</html>