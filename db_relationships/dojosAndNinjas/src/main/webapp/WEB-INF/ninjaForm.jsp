<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninja/new" method="post" modelAttribute="ninja">
		<div>
			<form:label path="dojo_id">Dojo: </form:label>
			<form:input path="dojo_id" />
		</div>
		<div>
			<form:label path="firstName">First Name: </form:label>
			<form:input path="firstName" />
		</div>
		<div>
			<form:label path="lastName">Last Name: </form:label>
			<form:input path="lastName" />
		</div>
		<div>
			<form:label path="age">Age: </form:label>
			<form:input path="age" />
		</div>
	</form:form>
</body>
</html>