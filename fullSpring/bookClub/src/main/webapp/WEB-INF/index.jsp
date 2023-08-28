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
	<h1>Book Club</h1>
	<p>A place for friends to share thoughts on books</p>
	<div>
		<!-- registration form -->
		<div>
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div>
					<form:label path="name">Name: </form:label>
					<form:input path="name" />
				</div>
				<div>
					<form:label path="email">Email: </form:label>
					<form:input path="email" />
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password" />
				</div>
				<div>
					<form:label path="confirm">Confirm Password: </form:label>
					<form:input path="confirm" type="password" />
				</div>
				<div>
					<p><form:errors path="name" /></p>
					<p><form:errors path="email" /></p>
					<p><form:errors path="password" /></p>
					<p><form:errors path="confirm" /></p>
				</div>
				<button>Register</button>
			</form:form>
		</div>
		<!-- login form -->
		<div>
			<h2>Login</h2>
			<form:form action="/login" method="post" modelAttribute="loginUser">
				<div>
					<form:label path="email">Email: </form:label>
					<form:input path="email" />
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password" />
				</div>
				<div>
					<p><form:errors path="email" /></p>
					<p><form:errors path="password" /></p>
				</div>
				<button>Login</button>
			</form:form>
		</div>
	</div>
</body>
</html>