<%@page import="model.Prenotazione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	
	<%
		Prenotazione pr=(Prenotazione)request.getAttribute("prenotazione");
		double prezzo=pr.getProiezione().getPrezzo()*pr.getNumPosti();
	%>
	
	<div class="container">
		<div class="jumbotron">
			<h1><%=pr.getProiezione().getFilm().getTitolo()%></h1>
			<h1><%=pr.getProiezione().getData()+" "+pr.getProiezione().getOra()%></h1>
			<h1><%=pr.getNumPosti()+" Posti: "+pr.getPosti()%></h1>
			<h1><%="Prezzo: "+prezzo%>&euro;</h1>
			<form action="PrenotazioneFilm" method="post">
				<input type="hidden" name="proiezione" value="<%=pr.getProiezione().getId()%>">
				<input type="hidden" name="numPosti" value="<%=pr.getNumPosti()%>">
				<input type="hidden" name="posti" value="<%=pr.getPosti()%>">
				<button type="submit" class="btn btn-outline-secondary">Conferma</button>
			</form>
			<a href="#" type="button" class="btn btn-outline-danger">Annulla</a>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>