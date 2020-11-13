<%@page import="model.User"%>
<!--NAVBAR-->
<div class="sticky-top">
	<nav class="navbar navbar-expand-lg navbar-light">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<a class="navbar-brand" href="/CinemaNapoli/Home/html/Home.jsp"> <img
					src="/CinemaNapoli/Home/res/Medea-Logo.png" width="30" height="30"
					class="d-inline-block align-top" alt="logo">
				</a>

				<li class="nav-item active"><a class="nav-link" href="/CinemaNapoli/Home/html/Home.jsp"><span
						class="titolinav">HOME</span></a></li>
				<li class="nav-item active"><a class="nav-link" href="#prezzi"><span
						class="titolinav">PROMO</span></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><span class="titolinav">
							PROIEZIONI</span> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#"><span class="titolinav">Ricerca
								per genere</span></a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="RicercaProiezione"><span class="titolinav">Ricerca
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
				</button></a>
			<a href="/CinemaNapoli/Logout"><button type="button"
					class="btn btn-outline-dark">
					<i class="fas fa-sign-out-alt"></i> Log-out
				</button></a>
		<% }else{ %>
			<button type="button" class="btn btn-outline-dark"
				data-toggle="modal" data-target="#exampleModalCenter">
				<i class="fas fa-user"></i>Login</i>
			</button>
			<a href="/CinemaNapoli/Home/html/Registrazione.jsp"><button type="button"
					class="btn btn-outline-dark">
					<i class="fas fa-user-edit"></i> Registrati
				</button></a>
		<% } %>
		
		</div>
	</nav>
</div>