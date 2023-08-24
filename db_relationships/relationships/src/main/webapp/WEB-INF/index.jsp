<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DMV</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Person Details:></h1>
	<table class="table">
	    <thead class="thead-dark">
	        <tr>
	            <th>Name</th>
	            <th>License Number</th>
	            <th>State</th>
	            <th>Expiration Date</th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr>
	            <td>
	                <c:out value="${person.first_name}"/>
	                <c:out value="${person.last_name}"/>
	            </td>
	            <td><c:out value="${person.license.number}"/></td>
	            <td><c:out value="${person.license.state}"/></td>
	            <td>
	                <c:out value="${person.license.expiration_date}"/>
	            </td>
	        </tr>
	    </tbody>
	</table>	
</body>
</html>