<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="mx-auto m-3 p-4 text-center border rounded border-primary bg-primary text-light" style="width: 450px;">
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books</p>
	</div>
	<div class="d-flex justify-content-evenly m-5"> 
		<!-- registration form -->
		<div>
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div>
					<form:label path="name" class="form-label">Name: </form:label>
					<form:input path="name" class="form-control"/>
				</div>
				<div>
					<form:label path="email" class="form-label">Email: </form:label>
					<form:input path="email" class="form-control"/>
				</div>
				<div>
					<form:label path="password" class="form-label">Password: </form:label>
					<form:input path="password" type="password" class="form-control"/>
				</div>
				<div>
					<form:label path="confirm" class="form-label">Confirm Password: </form:label>
					<form:input path="confirm" type="password" class="form-control"/>
				</div>
				<div>
					<p><form:errors path="name" /></p>
					<p><form:errors path="email" /></p>
					<p><form:errors path="password" /></p>
					<p><form:errors path="confirm" /></p>
				</div>
				<button class="btn btn-success">Register</button>
			</form:form>
		</div>
		<!-- login form -->
		<div>
			<h2>Login</h2>
			<form:form action="/login" method="post" modelAttribute="loginUser">
				<div>
					<form:label path="email" class="form-label">Email: </form:label>
					<form:input path="email" class="form-control"/>
				</div>
				<div>
					<form:label path="password" class="form-label">Password: </form:label>
					<form:input path="password" type="password" class="form-control"/>
				</div>
				<div>
					<p><form:errors path="email" /></p>
					<p><form:errors path="password" /></p>
				</div>
				<button class="btn btn-success">Login</button>
			</form:form>
		</div>
	</div>
</body>
</html>