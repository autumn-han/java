<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<h1>Welcome!</h1>
		<h3>Join our growing community</h3>
		<div>
			<h2>Register</h2>
			<form:form action="/user/register" method="post" modelAttribute="newUser">
				<div>
					<p><form:errors path="user_name" /></p>
					<p><form:errors path="email" /></p>
					<p><form:errors path="password" /></p>
					<p><form:errors path="confirm" /></p>
				</div>
				<div>
					<form:label path="user_name">Username: </form:label>
					<form:input path="user_name" />
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
				<button>Register</button>
			</form:form>
		</div>
		<div>
			<h2>Login</h2>
			<form:form action="/user/login" method="post" modelAttribute="newLogin">
				<div>
					<p><form:errors path="email" /></p>
					<p><form:errors path="password" /></p>
				</div>
				<div>
					<form:label path="email">Email: </form:label>
					<form:input path="email" />
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password" />
				</div>
				<button>Login</button>
			</form:form>
		</div>
	</div>
</body>
</html>