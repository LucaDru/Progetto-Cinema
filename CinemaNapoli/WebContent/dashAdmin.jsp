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
				class="nav-link active text-warning" id="film-tab" data-toggle="tab"
				href="#film" role="tab" aria-controls="film" aria-selected="false">Film</a></li>
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

			
		</div>

		<!-- Proiezioni tab -->
		<div
			class="tab-pane fade bg-dark text-warning justify-content-center text-center"
			id="proiezioni" role="tabpanel" aria-labelledby="proiezioni-tab">

			
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
									<a class="btn btn-outline-danger btn-sm" href="#"
									role="button">X</a>
									<a class="btn btn-outline-danger btn-sm" href="ResetPassword?reset=<%=u.getId() %>"
									role="button">Reset Password</a>
									<a class="btn btn-outline-danger btn-sm" href="AttivazioneAccount?attiva=<%=u.getId() %>"
									role="button">Attiva</a>
									<a class="btn btn-outline-danger btn-sm" href="AttivazioneAccount?disattiva=<%=u.getId() %>"
									role="button">Disattiva</a>
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