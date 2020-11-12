<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Privacy</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">

<link rel="stylesheet" href="/CinemaNapoli/Home/css/home.css">
<link rel="stylesheet" href="/CinemaNapoli/Home/css/login.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>

	<jsp:include page="login.jsp"></jsp:include>

	<!-- PRIVACY -->
	<div class="container">
		<div class="card pt-0" style="background-color: #7ea3cc;">
			<div class="card-title pt-5">
				<h2 style="text-align: center; color: black;">Informativa sulla privacy</h2>
			</div>
			<div class="card-body">
				<h5>Le seguenti norme sulla privacy - da intendersi rese anche
					quale informativa ai sensi dell'art. 13 del Regolamento europeo
					2016/679 "General Data Protection Regulation" - hanno lo scopo di
					descrivere le procedure di raccolta e utilizzo dei dati personali
					attraverso questo sito internet e sono rivolte agli utenti e ai
					fruitori del servizio</h5>
				</br>
				<h3>Finalita' del trattamento</h3>
				<h6>I dati di navigazione saranno utilizzati al fine di
					ricavare informazioni anonime sull'uso del sito e per controllarne
					il corretto funzionamento.</h6>
				</br>
				<h3>
					Cookie
				</h3>
					<h6>I cookie sono file di testo di dimensioni ridotte che
						alcuni siti salvano sui dispositivi utilizzati dall'utente per
						navigare attraverso il browser. I cookie vengono ritrasmessi ai
						siti stessi in occasione di visite successive.</h6>
					</br>
					<h6>Esistono due tipi di cookie: i cookie persistenti, che
						rimangono sul dispositivo dell'utente fino ad apposita volontaria
						azione di cancellazione degli stessi e i cookie di durata
						variabile, che possono cancellarsi alla chiusura del browser o
						alla fine della sessione in cui vengono creati. Le finalita' per
						cui Multisala Medea utilizza i cookie sono a scopo puramente di
						navigazione, volti a migliorare l'esperienza di navigazione e la
						fruizione del sito stesso da parte dell'utente</h6>
					</br>
					<h3>Come revocare il consenso all'utilizzo dei cookie?</h3>
					<h6>Poiche' il browser dell'utente memorizza i cookie
						inviati dal sito sul disco fisso, e' possibile agire sulle
						impostazioni del programma per poter disattivare la memorizzazione
						dei cookie.</h6>
			</div>
		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>

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

	<script src="/CinemaNapoli/Home/js/validateScript.js"></script>
</body>
</html>