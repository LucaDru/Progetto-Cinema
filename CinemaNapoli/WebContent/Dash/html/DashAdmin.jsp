<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MM-Pagina Gestione</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">
<link rel="stylesheet" href="/CinemaNapoli/Dash/css/dash.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Cantarell&family=Montserrat&display=swap" rel="stylesheet">
</head>

<body>
	<jsp:include page="navbarOri.jsp"></jsp:include>
	
	<!-- controllo delle TAB -->
  	<input type="hidden" value="0" id="controllo">
	
	<div class="container-fluid">
	<div class="row">
		<jsp:include page="navVertAdmin.jsp"></jsp:include>
		
		<div class="tab-content col-md-9 ml-sm-auto col-lg-10 px-md-4" id="myTabContent">
			<!-- Dashboard HOME -->
			<jsp:include page="dashHomeAdmin.jsp"></jsp:include>
			
			<!-- Utenti TAB -->
			<div class="tab-pane fade"
				id="users" role="tabpanel" aria-labelledby="users-tab">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Utenti & Staff</h1>
				</div>
				<jsp:include page="tabAttivare.jsp"></jsp:include>
				<jsp:include page="tabStaff.jsp"></jsp:include>
				<jsp:include page="tabUsers.jsp"></jsp:include>
				<jsp:include page="tabCancellati.jsp"></jsp:include>
				<jsp:include page="tabBannati.jsp"></jsp:include>
			</div>
			
			<!-- Proiezioni -->
			<div class="tab-pane fade"
				id="proiezioni" role="tabpanel" aria-labelledby="proiezioni-tab">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Proiezioni</h1>
				</div>
				<div class="pt-3 pb-2 mb-3 text-center">
          			<button class="btn btn-warning" type="button" data-toggle="collapse"
						data-target="#inserisci-proiezione" aria-expanded="false"
						aria-controls="collapseExample">Inserisci Proiezione</button>
				</div>
				<jsp:include page="insertProiezione.jsp"></jsp:include>
				<jsp:include page="tabProiezioni.jsp"></jsp:include>
			</div>
			
			<!-- Film e Generi -->
			<div class="tab-pane fade"
				id="film" role="tabpanel" aria-labelledby="film-tab">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Film & Generi</h1>
				</div>
				<div class="pt-3 pb-2 mb-3 text-center">
					<button class="btn btn-warning" type="button"
						data-toggle="collapse" data-target="#inserisci-film"
						aria-expanded="false" aria-controls="collapseExample">Inserisci
							Film</button>
					<button class="btn btn-warning" type="button"
						data-toggle="collapse" data-target="#inserisci-genere"
						aria-expanded="false" aria-controls="collapseExample">Inserisci
							Genere</button>
				</div>
				<jsp:include page="insertGenere.jsp"></jsp:include>
				<jsp:include page="insertFilm.jsp"></jsp:include>
				<jsp:include page="tabGenere.jsp"></jsp:include>
				<jsp:include page="tabFilm.jsp"></jsp:include>
			</div>
			
			<!-- Sale -->
			<div class="tab-pane fade"
				id="sale" role="tabpanel" aria-labelledby="sale-tab">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Sale</h1>
				</div>
				<div class="pt-3 pb-2 mb-3 text-center">
					<button class="btn btn-warning" type="button" data-toggle="collapse"
						data-target="#inserisci-sala" aria-expanded="false"
						aria-controls="collapseExample">Inserisci Sala</button>
				</div>
				<jsp:include page="insertSala.jsp"></jsp:include>
				<jsp:include page="tabSale.jsp"></jsp:include>
			</div>
			
			<!-- Profilo -->
			<div class="px-md-4 tab-pane fade"
				id="profilo" role="tabpanel" aria-labelledby="profilo-tab">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Riepilogo</h1>
				</div>
			</div>
		</div>
	</div>
	</div>
	
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
		
	<script src="/CinemaNapoli/Dash/js/icone.js"></script>
</body>
</html>