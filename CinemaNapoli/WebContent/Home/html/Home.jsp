<%@page import="model.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MM-Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">
	
<link rel="stylesheet" href="/CinemaNapoli/Home/css/ciaobea.css">
<link rel="stylesheet" href="/CinemaNapoli/Home/css/login.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Cantarell&family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>

<%
	List<Film> lista=(List<Film>)request.getAttribute("listaFilm");
%>
	
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<jsp:include page="login.jsp"></jsp:include>
	<input type="hidden" id="controllo" value="<%=request.getAttribute("controllo")!=null? request.getAttribute("controllo"): 0%>">
	<!--CAROSELLO-->
	<div class="film-sala text-right">

		<div class="film-sala-titolo">Film in sala</div>

		<div id="carosello" class="carousel slide d-inline-flex"
			data-ride="carousel">
			
			<div class="carousel-inner">
			<% 
				for(int i=0;i<lista.size();i++){
					if(i==0){
			%>			
				<div class="carousel-item active filmetto"
					style="background-image: url(<%=lista.get(i).getLocandina()%>);">
					<a href="RicercaFilm?idFilm=<%=lista.get(i).getId() %>">
						<div class="sovrapposto">
							DETTAGLI</br> <i class="fas fa-plus"></i>
						</div>
					</a>
				</div>
				<%}else{ %>
				<div class="carousel-item filmetto"
					style="background-image: url(<%=lista.get(i).getLocandina()%>);">
					<a href="RicercaFilm?idFilm=<%=lista.get(i).getId() %>">
						<div class="sovrapposto">
							DETTAGLI</br> <i class="fas fa-plus"></i>
						</div>
					</a>
				</div>
			<% }} %>
			</div>

			<a class="carousel-control-prev" href="#carosello" role="button"
				data-slide="prev"> <span aria-hidden="true"><i
					class="fas fa-step-backward comandi"></i></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carosello" role="button"
				data-slide="next"> <span aria-hidden="true"><i
					class="fas fa-step-forward comandi"></i></span> <span class="sr-only">Next</span>
			</a>
		</div>

	</div>

	<!--INTRAMEZZO-->
	<div class="container-fluid">
		<div class="intramezzo">
			<div class="logo"></div>
		</div>
	</div>


	<!-- card eventi e promo -->
    <div class="container-fluid">
        <div class="row m-0">
            <div class="col-1 p-0 m-0"></div>
            <div class="col-5">
                <div class="card text-center shadow sfondogrigio miao">
                    <div class="primacard">
                        <h5 class="card-header">Eventi</h5>
                        <div class="card-body barattolo-due">
                            <h5 class="card-title">Cinema Vintage</h5>
                            <p class="card-text">Sei un amante del genere Cult? Vieni a trovarci tutti i marted&iacute;
                                per rivivere i Grandi Classici del cinema</p>
                            <h5 class="card-title insert">Il primo mercoled&iacute; di ogni mese, tutti gli spettacoli
                                costano 2&euro;
                            </h5>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-5">
                <div class="card text-center shadow sfondogrigio miao">
                    <div class="secondacard">
                        <a name="prezzi">
                        </a>
                        <h5 class="card-header">Promozioni</h5>
                        <div class="card-body barattolo">
                            <div class="row">
                                <div class="col-6">
                                    <h5 class="card-title">Listino</h5>
                                    <p class="card-text">proiezioni 2D: 7,50&euro; <br> proiezioni 3D: 10&euro;</p>
                                </div>
                                <div class="col-6">
                                    <h5 class="card-title">Riduzioni</h5>
                                    <p class="card-text">under 12 e over 65: 5&euro;</p>
                                </div>
                            </div>
                            <h5 class="card-title mt-4 insert border-top border-dark pt-4">Il primo mercoledi' di ogni
                                mese, tutti gli spettacoli
                                costano
                                2&euro;</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-1 p-0 m-0"></div>
        </div>
    </div>

	<!--MEDEA-->

    <div class="container mt-3" style="background-color: #2c031e;">
        <div class="row">
            <div class="col-8 testomedea">
                <h2 class="titolomedea">Perche' Medea?</h2>
				<p class="paragM">Medea è uno dei personaggi più celebri e
					controversi della mitologia greca; Eroina protofemminista della
					classicità riportata sul grande schermo da registi del calibro di
					Lars Von Trier e Pier Paolo Pasolini. Il Multisala Medea nasce dal
					connubio tra modernità e classicismo, offriamo infatti la visione
					di tutte le ultime uscite cinematografiche, oltre ad eventi
					esclusivi con ricorrenza settimanale per rivivere i Grandi classici
					del cinema.</p>
			</div>
			<div class="col-4 pr-4">
           		<img src="/CinemaNapoli/Home/res/medea.jpg" alt="img medea" class="img-medea">
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
		
	<script src="/CinemaNapoli/Home/js/scriptLogin.js"></script>
	<script src="/CinemaNapoli/Home/js/Script.js"></script>
    <script src="/CinemaNapoli/Home/js/validateScript.js"></script>
</body>
</html>