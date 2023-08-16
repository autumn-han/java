<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>
</head>
<body>
	<h3>Fruit Store</h3>
	<table>
		<tbody>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="fruit" items="${fruits}" >
				<tr>
					<td><c:out value="${fruit.name}" /></td>
					<td><c:out value="${fruit.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>