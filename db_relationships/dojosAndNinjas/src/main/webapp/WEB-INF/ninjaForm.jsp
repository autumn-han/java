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
	<!-- select input that displays all dojos in the db to select from -->
		<div>
			<form:select path="dojo_id">
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}" path="dojo_id">
						<c:out value="${dojo.name}" />
					</form:option>
				</c:forEach>
			</form:select>
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
		<button>Add Ninja</button>
	</form:form>
</body>
</html>