<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MM-Profilo Utente</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">
	
<!-- <link rel="stylesheet" href="/CinemaNapoli/Home/css/ciaobea.css"> -->
<link rel="stylesheet" href="/CinemaNapoli/Dash/css/dash.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Cantarell&family=Montserrat&display=swap" rel="stylesheet">
<style>
	@import url('https://fonts.googleapis.com/css2?family=Libre+Barcode+39+Text&display=swap');
</style>
</head>
<body style="background-color: #993333;">
	<jsp:include page="navbarOri.jsp"></jsp:include>
	
	<div class="container-fluid px-0">
        <div class="row mx-0">
        	<jsp:include page="navVertUtente.jsp"></jsp:include>
        	<div class="tab-content col-md-9 ml-sm-auto col-lg-10 px-md-4" id="superTabContent">
        		<div class="tab-pane fade show active" id="prenotazioniUtente" role="tabpanel" aria-labelledby="prenotazioniUtente-tab">
        			<jsp:include page="mainUtente.jsp"></jsp:include>
        		</div>
        		<div class="tab-pane fade" id="modificaProfilo" role="tabpanel" aria-labelledby="modificaProfilo-tab">
        			<jsp:include page="modificaProfilo.jsp"></jsp:include>
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
		
	<script src="/CinemaNapoli/Dash/js/sorting.js"></script>
</body>
</html>