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
	<div class="mt-5">
		<h2 class="text-center">You're Gold: <c:out value="${gold}" /></h2>
	</div>
	<div class="text-center">
		<a href="/reset"><button class="btn btn-primary">Reset</button></a>
	</div>
	<div class="d-flex p-3 justify-content-evenly">
		<div class="border border-success border-2 rounded p-3" style="width: 250px">
			<form action="/submit" method="post">
				<input type="hidden" name="farm" />
				<p class="fw-bold">Farm</p>
				<p>(earns 10-20 gold)</p>
				<button class="btn btn-success">Find Gold</button>
			</form>
		</div>
		<div class="border border-success border-2 rounded p-3" style="width: 250px">
			<form action="/submit" method="post">
				<input type="hidden" name="cave" />
				<p class="fw-bold">Cave</p>
				<p>(earns 5-10 gold)</p>
				<button class="btn btn-success">Find Gold</button>
			</form>
		</div>
		<div class="border border-success border-2 rounded p-3" style="width: 250px">
			<form action="/submit" method="post">
				<input type="hidden" name="house" />
				<p class="fw-bold">House</p>
				<p>(earns 2-5 gold)</p>
				<button class="btn btn-success">Find Gold</button>
			</form>
		</div>
		<div class="border border-warning border-2 rounded p-3" style="width: 250px">
			<form action="/submit" method="post">
				<input type="hidden" name="quest" />
				<p class="fw-bold">Quest</p>
				<p>(earns/loses 0-50 gold)</p>
				<button class="btn btn-warning">Find/Lose Gold</button>
			</form>
		</div>
		<div class="border border-danger border-2 rounded p-3" style="width: 250px">
			<form action="/submit" method="post">
				<input type="hidden" name="spa" />
				<p class="fw-bold">Spa</p>
				<p>(loses 5-20 gold)</p>
				<button class="btn btn-danger">Spend Gold</button>
			</form>
		</div>
	</div>
	<div class="container mx-auto">
		<div class="w-50 text-center">
			<table class="table">
				<thead>
					<tr>
						<th>Activities: </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="activity" items="${activities}">
						<tr><td><c:out value="${activity}" /></td></tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>