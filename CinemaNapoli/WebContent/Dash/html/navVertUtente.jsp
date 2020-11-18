<%@page import="model.User"%>
<%
	User u = (User) request.getSession().getAttribute("userLoggato");
%>

<!-- profilo personale-->
<nav id="sidebarMenu"
	class="col-md-3 col-lg-2 d-md-block bg-light <!--  sidebar sidebar-fixed--> collaps"
	style="background-color: lightgray !important;">
	<div class="p-3">
		<br> <br>
		<h2 class="pl-2">Il tuo profilo:</h2>
		<div class="card my-4">
			<div class="card-body row">
				<div class="col-8 row">
					<div class="pr-2 pl-2">
						<p>Info:</p>
						<p><%=u.getNome() + " " + u.getCognome()%></p>
						<p><%=u.getDatadinascita()%></p>
					</div>
				</div>
			</div>
		</div>
		<div class="card my-4">
			<div class="card-body row">
				<div class="col-8 row">
					<div class="pr-2 pl-2">
						<p>Info Account:</p>
						<p>
							Username:
							<%=u.getUsername()%></p>
						<p>password: ********</p>
						<p><%=u.getEmail()%></p>
					</div>
				</div>
			</div>
		</div>
		<div class="card my-4">
			<div class="card-body row">
				<div class="col-8 row">
					<div class="pr-2 pl-2">
						<p>Info Fatturazione:</p>
						<p><%=u.getIndirizzo()%></p>
						<p><%=u.getCap() + " " + u.getCitta() + "(" + u.getProvincia() + ")"%></p>
						<hr>
						<p>
							CF:
							<%=u.getCf()%></p>
					</div>
				</div>
			</div>
		</div>

		<div class="text-center border-bottom my-3 p-3">
			
			<a class="link btn btn-secondary" id="modificaProfilo-tab"
					href="#modificaProfilo" data-toggle="tab" role="tab" aria-controls="modificaProfilo"
					aria-selected="false">Modifica</a>
		</div>
	</div>
</nav>