<%@page import="model.User"%>
<%
	User u=(User)request.getSession().getAttribute("userLoggato");
%>

<!-- navbar verticale -->

	<nav id="sidebarMenu"
		class="col-md-3 col-lg-2 d-md-block bg-light sidebar sidebar-fixed collapse">
		<div class="pt-3 portacose">
			<h6
				class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
				<span>Principale</span>
			</h6>
			<ul class="nav flex-column" role="tablist">
				<li class="nav-item" role="presentation"><a
					class="nav-link active punti" id="home-tab" href="#home"
					data-toggle="tab" role="tab" aria-controls="home"
					aria-selected="true"> <i class="fas fa-home icona mr-2"></i> <span>Dashboard</span>
				</a></li>
				<h6
					class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
					<span>Gestione</span>
				</h6>
				<li class="nav-item"><a class="nav-link punti" id="users-tab"
					href="#users" data-toggle="tab" role="tab" aria-controls="users"
					aria-selected="false"> <i
						class="fas fa-people-arrows icona mr-2"></i> <span>Utenti &
							Staff</span>
				</a></li>
				<li class="nav-item"><a class="nav-link punti"
					id="proiezioni-tab" href="#proiezioni" data-toggle="tab" role="tab"
					aria-controls="proiezioni" aria-selected="false"> <i
						class="fas fa-video icona mr-2"></i> <span>Proiezioni</span>
				</a></li>
				<li class="nav-item"><a class="nav-link punti" id="film-tab"
					href="#film" data-toggle="tab" role="tab" aria-controls="film"
					aria-selected="false"> <i class="fas fa-film icona mr-2"></i> <span>Film
							e Generi</span>
				</a></li>
				<li class="nav-item"><a class="nav-link punti" id="sale-tab"
					href="#sale" data-toggle="tab" role="tab" aria-controls="sale"
					aria-selected="false"> <i class="fas fa-archway icona mr-2"></i>
						<span>Sale</span>
				</a></li>

				<h6
					class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
					<span>Profilo</span>
				</h6>

				<li class="nav-item"><a class="nav-link punti"
					id="profilo-tab" href="#profilo" data-toggle="tab" role="tab"
					aria-controls="profilo" aria-selected="false"> <i
						class="fas fa-address-book icona mr-2"></i> <span>Riepilogo</span>
				</a></li>
			</ul>
		</div>
		<div class="sidebar-bottom d-none d-lg-block connesso">
			<div class="media">
				<img src="../res/locandina 4.jpg" alt=""
					class="rounded-circle mr-3 mt-1" width="40" height="40">
				<div class="media-body">
					<h5 class="mb-1"><%=u.getNome()+" "+u.getCognome()%></h5>
					<div>
						<i class="fas fa-circle text-success"></i> Online
					</div>
				</div>
			</div>
		</div>
	</nav>
