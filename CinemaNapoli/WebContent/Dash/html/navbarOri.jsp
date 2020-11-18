<%@page import="model.User"%>
<%
	User us=(User)request.getSession().getAttribute("userLoggato");
%>

<nav
	class="navbar navbar-dark sticky-top flex-md-nowrap p-0 shadow prova">
	<a class="navbar-brand col-md-3 col-lg-2 mr-0 p-0" href="/CinemaNapoli/Inizializzazione"> <img
		src="/CinemaNapoli/Home/res/Medea-Logo-bianco.png" alt="logo" width="70" height="70"
		class="mx-3"> <span class="testo">HOME</span>
	</a>
	<button class="navbar-toggler position-absolute d-md-none collapsed"
		type="button" data-toggle="collapse" data-target="#sidebarMenu"
		aria-controls="sidebarMenu" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
		<ul class="navbar-nav px-3 list-group-horizontal">
		<%
			if(!us.getRuolo().getNome().equals("user")){
		%>
		<li class="nav-item text-nowrap mx-3">
			<a href="Reindirizzamento"><button type="button"
					class="btn btn-outline-secondary">
					<i class="fas fa-edit"></i>Dashboard
				</button></a>
			</li>
		<%
			}
		%>

		<li class="nav-item text-nowrap mx-3"><a
			class="btn btn-outline-secondary" href="/CinemaNapoli/Logout" role="button" id="miao"><i
				class="fas fa-sign-out-alt"></i> Log-out</a></li>
	</ul>
</nav>