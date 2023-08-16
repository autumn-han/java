<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji</h1>
	<form action="/submit" method="post">
		<div>
			<label>Pick any number from 5 to 25: </label>
			<input name="number" type="number" min="5" max="25" />
		</div>
		<div>
			<label>Enter the name of any city: </label>
			<input name="city" type="text" />
		</div>
		<div>
			<label>Enter the name of any person: </label>
			<input name="person" type="text" />
		</div>
		<div>
			<label>Enter a professional endeavor or hobby: </label>
			<input name="activity" type="text" />
		</div>
		<div>
			<label>Enter a species of animal: </label>
			<input name="animal" type="text" />
		</div>
		<div>
			<label>Write something nice about someone you know: </label>
			<textarea name="blurb" rows="4" cols="50"></textarea>
		</div>
		<p>Send and show a friend</p>
		<button>Send</button>
	</form>
</body>
</html>