<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Dash-Admin</title>
<!-- CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>

<body class="bg-dark">
	<div class="container bg-dark text-warning text-center">
		<h1>DASHBOARD ADMIN!</h1>
		<a class="btn btn-danger" href="Logout" role="button">Log-out</a>
	</div>
	
	<nav class="navbar navbar-dark bg-dark justify-content-center">
		<ul class="nav nav-tabs bg-dark" id="myTab" role="tablist">
			<!-- PROFILO -->
			<li class="nav-item" role="presentation"><a
				class="nav-link active text-warning" id="profilo-tab" data-toggle="tab"
				href="#profilo" role="tab" aria-controls="profilo" aria-selected="true">Profilo</a></li>
			<!-- FILM -->
			<li class="nav-item" role="presentation"><a
				class="nav-link text-warning" id="film-tab" data-toggle="tab"
				href="#film" role="tab" aria-controls="film" aria-selected="false">Film</a></li>
			<!-- GENERE -->	
				<li class="nav-item" role="presentation"><a
				class="nav-link text-warning" id="fgenere-tab" data-toggle="tab"
				href="#fgenere" role="tab" aria-controls="fgenere" aria-selected="false">Genere</a></li>
			<!-- SALA -->
			<li class="nav-item" role="presentation"><a
				class="nav-link text-warning" id="sala-tab" data-toggle="tab"
				href="#sala" role="tab" aria-controls="sala" aria-selected="false">Sale</a></li>
			<!-- PROIEZIONI -->
			
			<li class="nav-item" role="presentation"><a
				class="nav-link text-warning" id="proiezioni-tab" data-toggle="tab"
				href="#proiezioni" role="tab" aria-controls="proiezioni" aria-selected="false">Proiezioni</a></li>
			<!-- UTENTI -->
			<li class="nav-item" role="presentation"><a
				class="nav-link text-warning" id="utenti-tab" data-toggle="tab"
				href="#utenti" role="tab" aria-controls="utenti"
				aria-selected="false">Utenti</a></li>
		</ul>
	</nav>
	<div class="tab-content" id="myTabContent">
	
		<!-- Profilo tab -->
		<div
			class="tab-pane fade show active bg-dark text-center text-warning"
			id="profilo" role="tabpanel" aria-labelledby="profilo-tab">
			
			<jsp:include page="modificaProfilo.jsp"></jsp:include>
			
		</div>

		<!-- Film tab -->
		<div
			class="tab-pane fade bg-dark text-center text-warning"
			id="film" role="tabpanel" aria-labelledby="film-tab">
			
			<h3>Inserisci nuovo Film:</h3>
			
			<hr class="bg-warning">
			<h3>Lista Film:</h3>
			<jsp:include page="tabellaFilm.jsp"></jsp:include>
			
		</div>
		
		<!-- Genere tab -->
		<div
			class="tab-pane fade bg-dark text-center text-warning"
			id="fgenere" role="tabpanel" aria-labelledby="fgenere-tab">
			
			<h3>Inserisci nuovo Genere:</h3>
			
			<hr class="bg-warning">
			<h3>Lista Genere:</h3>
			<jsp:include page="tabellaGenere.jsp"></jsp:include>
			
		</div>
		

		
		<!-- Sala tab -->
		<div
			class="tab-pane fade bg-dark text-center text-warning"
			id="sala" role="tabpanel" aria-labelledby="sala-tab">
			
			<h3>Inserisci nuova sala:</h3>
			<jsp:include page="inserisciSala.jsp"></jsp:include>
			<hr class="bg-warning">
			<h3>Lista Sale:</h3>
			<jsp:include page="tabellaSale.jsp"></jsp:include>
		</div>

		<!-- Proiezioni tab -->
		<div
			class="tab-pane fade bg-dark text-warning justify-content-center text-center"
			id="proiezioni" role="tabpanel" aria-labelledby="proiezioni-tab">

			<h3>Inserisci nuova proiezione:</h3>
			<jsp:include page="inserisciProiezione.jsp"></jsp:include>
			<hr class="bg-warning">
			<h3>Lista Proiezioni:</h3>
			<jsp:include page="tabellaProiezioni.jsp"></jsp:include>
			
		</div>

		<!-- Utenti tab -->
		<div
			class="tab-pane fade bg-dark text-warning justify-content-center text-center"
			id="utenti" role="tabpanel" aria-labelledby="utenti-tab">

			<hr class="bg-warning">
			<p>Elenco Utenti</p>
			<hr>
			<div class="container" id="elenco-utenti">
				<div class="card card-body">
					<%
						List<User> listaUtenti = (List<User>)request.getAttribute("leggiUser");
					%>
					<table class="table table-sm table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nome</th>
								<th scope="col">Cognome</th>
								<th scope="col">...</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (User u : listaUtenti) {
							%>
							<tr>
								<th scope="row"><%=listaUtenti.indexOf(u)+1%></th>
								<td><%=u.getNome()%></td>
								<td><%=u.getCognome()%></td>
								<td>
									<a class="btn btn-outline-info btn-sm" href="ResetPassword?reset=<%=u.getId() %>"
									role="button">Reset Password</a>
									<a class="btn btn-outline-warning btn-sm" href="AssegnaRuoli?staff=<%=u.getId() %>"
									role="button">Staff</a>
									<a class="btn btn-outline-primary btn-sm" href="AssegnaRuoli?user=<%=u.getId() %>"
									role="button">Accetta</a>
									<a class="btn btn-outline-danger btn-sm" href="AssegnaRuoli?bannato=<%=u.getId() %>"
									role="button">Bann</a>
									<a class="btn btn-outline-danger btn-sm" href="AttivazioneAccount?disattiva=<%=u.getId() %>"
									role="button">X</a>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	
	<!-- SCRIPT NO RITORNO -->
	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
	</script>
	
	<!-- jQuery and JS bundle w/ Popper.js -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>