<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Home</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>

	<div class="container text-center text-danger my-5">
		<h1>Questa è la mia HOME-PAGE</h1>
	</div>

	<%
		if (request.getSession().getAttribute("userLoggato") != null) {
			User u = (User) request.getSession().getAttribute("userLoggato");
	%>
	<div class="container text-center">
		<h2>
			Benvenuto <%=u.getNome()%>
		</h2>
		<a class="btn btn-outline-secondary" href="Reindirizzamento" role="button">Dashboard</a>
		<a class="btn btn-danger" href="Logout" role="button">Log-out</a>
	</div>
	<%
		} else {
	%>
	<div class="container">
		<form action="Login" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label> <input
					name="username" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					name="password" type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<!--  -->
	<div class="container text-center my-5">
		<p>
			Non sei ancora registrato al sito? <a href="registrazione.jsp">Registrati</a> ora!
		</p>
	</div>
	
	<%
		}
	%>


	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>