<%@page import="model.User"%>
<!--NAVBAR-->
<div class="sticky-top aiutoo">
	<nav class="navbar navbar-expand-lg navbar-light py-0">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<a class="navbar-brand py-0" href="/CinemaNapoli/Inizializzazione"> <img
				src="/CinemaNapoli/Home/res/Medea-Logo-prugna.png" width="70" height="70"
				class="d-inline-block align-top" alt="logo-prugna">
			</a>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/CinemaNapoli/Inizializzazione"><span
						class="titolinav">HOME</span></a></li>
				<li class="nav-item active"><a class="nav-link" href="#prezzi"><span
						class="titolinav">PROMO</span></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><span class="titolinav">
							PROIEZIONI</span> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="RicercaGenere"><span class="titolinav">Ricerca
								per genere</span></a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="/CinemaNapoli/RicercaFilm"><span class="titolinav">Ricerca
								avanzata</span></a>
					</div></li>

			</ul>
		</div>
		<div class="nav-item active float-right">

			<%
				if (request.getSession().getAttribute("userLoggato") != null) {
				User u = (User) request.getSession().getAttribute("userLoggato");
			%>
			<a href="Reindirizzamento"><button type="button"
					class="btn btn-outline-dark">
					<i class="fas fa-edit"></i>Dashboard
				</button></a> <a href="/CinemaNapoli/Logout"><button type="button"
					class="btn btn-outline-dark">
					<i class="fas fa-sign-out-alt"></i> Log-out
				</button></a>
			<%
				} else {
			%>
			<button type="button" class="btn btn-outline-dark" id="bottoneLog"
				data-toggle="modal" data-target="#exampleModalCenter">
				<i class="fas fa-user"></i>Login
			</button>
			<a href="/CinemaNapoli/Home/html/registrazioneFinale.jsp"><button
					type="button" class="btn btn-outline-dark">
					<i class="fas fa-user-edit"></i> Registrati
				</button></a>
			<%
				}
			%>

		</div>
	</nav>
</div>