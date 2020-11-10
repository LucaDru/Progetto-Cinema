<%@page import="model.Proiezione"%>
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
	
	<%
		Proiezione p=(Proiezione)request.getAttribute("proiezione");
	%>
	
	<div class="container text-center text-danger my-5">
		<h1>Inserisci il tuo codice fiscale o partita iva</h1>
	</div>

	<div class="container">
		<form action="ModificaUser" method="post">
			<div class="form-group">
			<input type="hidden" name ="fatturazione" value ="si">			
				<label for="exampleInputEmail1">Codice Fiscale</label> <input
					name="cf" type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" pattern="^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$"> 
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Partita Iva</label> <input
					name="piva" type="text" class="form-control"
					id="exampleInputPassword1">
			</div>
			
			<input type="hidden" name="proiezione" value="<%=p.getId()%>">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

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