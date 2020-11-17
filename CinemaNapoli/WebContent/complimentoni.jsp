<%@page import="model.Proiezione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">
	
<link rel="stylesheet" href="/CinemaNapoli/Home/css/ciaobea.css">
<link rel="stylesheet" href="/CinemaNapoli/Home/css/login.css">
<link href="style-posti.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Cantarell&family=Montserrat&display=swap" rel="stylesheet">
</head>
<body class="bg-dark">
	
	<jsp:include page="Home/html/header.jsp"></jsp:include>
	<jsp:include page="Home/html/navbar.jsp"></jsp:include>
	
	<jsp:include page="Home/html/login.jsp"></jsp:include>
	<%
		Proiezione p = (Proiezione) request.getAttribute("proiezione");
	%>

	<div class="container">
		<div class="jumbotron text-center">
			<h1><%=p.getFilm().getTitolo()%></h1>
			<hr>
			<h3><%=p.getData() + " " + p.getOra()%></h3>
			<hr>
			<button class="btn btn-success" type="button" id="prosegui">
				Prosegui</button>
		</div>
	</div>

	<div class="container">
		<ul class="showcase">
			<li>
				<div class="seat"></div> <small>Disponibile</small>
			</li>
			<li>
				<div class="seat selected"></div> <small>Selezionato</small>
			</li>
			<li>
				<div class="seat occupied"></div> <small>Occupato</small>
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
    	
    	<form action="PrenotazioneFilm" method="post" id="inviaPosti">
    		<input type="hidden" name="numPosti" id="inputNumPosti">
    		<input type="hidden" name="stringaPosti" id="inputPostiSpecifici">
    		<input type="hidden" name="idProiezione" value="<%=p.getId()%>">
    	</form>
	</div>
	
	<!-- Riepilogo Modale -->
	<div class="modal fade" id="riepilogone-posti" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h5 class="modal-title" id="exampleModalLongTitle">Riepilogo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h1><%=p.getFilm().getTitolo()%></h1>
					<input type="hidden" id="prezzo" value="<%=p.getPrezzo()%>">
					<hr>
					<span>Hai selezionato</span>
					<span id="riepilogo-posti"></span>
					<span>posti:</span>
					</br>
					<span id="riepilogo-posti-codice"></span>
					<span>Prezzo totale: </span>
					<span id="riepilogo-prezzo"></span>
				</div>
				<div class="modal-footer">
					<button type="button" id="conferma-posti">Conferma</button>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="Home/html/footer.jsp"></jsp:include>
	<!-- BootStrap -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		<%@ include file="script-posti.js" %>
	</script>
</body>
</html>