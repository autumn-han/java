<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div>
		<h2>Your Gold: <c:out value="${gold}" /></h2>
	</div>
	<div>
		<a href="/reset"><button>Reset</button></a>
	</div>
	<div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="farm" />
				<p>Farm</p>
				<p>(earns 10-20 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="cave" />
				<p>Cave</p>
				<p>(earns 5-10 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="house" />
				<p>House</p>
				<p>(earns 2-5 gold)</p>
				<button>Find Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="quest" />
				<p>Quest</p>
				<p>(earns/loses 0-50 gold)</p>
				<button>Find/Lose Gold</button>
			</form>
		</div>
		<div>
			<form action="/submit" method="post">
				<input type="hidden" name="spa" />
				<p>Spa</p>
				<p>(loses 5-20 gold)</p>
				<button>Spend Gold</button>
			</form>
		</div>
	</div>
	<div>
		<p>Activities: </p>
		<div>
			<c:forEach var="activity" items="${activities}">
				<p><c:out value="${activity}" /></p>
			</c:forEach>
		</div>
	</div>
</body>
</html>