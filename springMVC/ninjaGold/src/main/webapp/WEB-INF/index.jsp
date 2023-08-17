<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>
	<div>
		<h2>Your Gold: <c:out value="${gold}" /></h2>
	</div>
	<div>
		<div>
			<form action="/submit" method="post">
				<p>Farm</p>
				<p>(earns 10-20 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<p>Cave</p>
				<p>(earns 5-10 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<p>House</p>
				<p>(earns 2-5 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<p>Quest</p>
				<p>(earns/takes 0-50 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
	</div>
	<div>
		<p>Activities: </p>
		<div>
			<!-- put in array of activities and loop through -->
		</div>
	</div>
</body>
</html>