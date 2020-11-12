<%@page import="model.Proiezione"%>
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
	
<link href="style-posti.css" rel="stylesheet">
</head>
<body class="bg-dark">

	<%
		Proiezione p = (Proiezione) request.getAttribute("proiezione");
	%>

	<div class="container">
		<div class="jumbotron text-center">
			<h1><%=p.getFilm().getTitolo()%></h1>
			<hr>
			<h3><%=p.getData() + " " + p.getOra()%></h3>
			<hr>
			<a class="btn btn-success btn-sm" href="#" role="button">Scegli
				Posti</a>
		</div>
	</div>

	<div class="container">
		<ul class="showcase">
			<li>
				<div class="seat"></div> <small>N/A</small>
			</li>
			<li>
				<div class="seat selected"></div> <small>Selected</small>
			</li>
			<li>
				<div class="seat occupied"></div> <small>Occupied</small>
			</li>
		</ul>
		
		<div class="sala">
    		<div class="screen"></div>
    		<%
    			int file=p.getPosti().length/10;
    			int cont=0;
    			for(int i=0; i<file;i++){
    		%>
    			<div class="fila">    			
    		<%
    				for(int j=0;j<10;j++){
    					if(p.getPosti()[cont]){    						
    		%>
    				<div class="seat occupied" id="<%=cont%>"></div>
    				<% } else { %>
    				<div class="seat" id="<%=cont%>"></div>
    		<% 
    					}
    					cont++;
    				} 
    		%>
    			</div>
    		<% } %>
    	</div>
    	
    	<form action="RiepilogoPosti" method="post" id="confermaPosti">
    		<input type="hidden" name="numPosti" id="inputNumPosti">
    		<input type="hidden" name="stringaPosti" id="inputPostiSpecifici">
    		<input type="hidden" name="idProiezione" value="<%=p.getId()%>">
    		<button type="submit" class="btn btn-outline-secondary">Conferma</button>
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
	<script type="text/javascript">
		<%@ include file="script-posti.js" %>
	</script>
</body>
</html>