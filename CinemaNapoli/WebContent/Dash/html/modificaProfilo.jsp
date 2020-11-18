<%@page import="model.User"%>
<%
	User u = (User) request.getSession().getAttribute("userLoggato");
%>

<div class="jumbotron my-5">
	<div class="container text-dark">

		<form action="/CinemaNapoli/ModificaUser" method="post">
			<input type="hidden" name="id" value="<%=u.getId()%>">

			<div class="form-group">
				<label for="inputAddress2">Citta</label> <input name="citta"
					type="text" class="form-control" id="inputAddress2"
					value="<%=u.getCitta()%>">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">Provincia</label> <input name="provincia"
						type="text" class="form-control" id="inputCity"
						value="<%=u.getProvincia()%>">
				</div>
				<div class="form-group col-md-4">
					<label for="inputState">Indirizzo</label> <input name="indirizzo"
						type="text" class="form-control" id="inputCity"
						value="<%=u.getIndirizzo()%>">
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Cap</label> <input name="cap" type="text"
						class="form-control" id="inputZip" value="<%=u.getCap()%>">
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Codice Fiscale</label> <input name="cf"
						type="text" class="form-control" id="inputZip"
						value="<%=u.getCf() == null ? "" : u.getCf()%>">
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Partita Iva</label> <input name="piva"
						type="text" class="form-control" id="inputZip"
						value="<%=u.getPiva() == null ? "N/D" : u.getPiva()%>">
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">E-mail</label> <input name="email"
						type="text" class="form-control" id="inputZip"
						value="<%=u.getEmail()%>">
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Username</label> <input name="username"
						type="text" class="form-control" id="inputZip"
						value="<%=u.getUsername()%>">
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Password</label> <input name="password"
						type="password" class="form-control" id="inputZip"
						value="<%=u.getPassword()%>">
				</div>

				<button type="submit" class="btn btn-info">Modifica</button>
			</div>
		</form>
		<a class="btn btn-secondary" id="prenotazioniUtente-tab"
					href="/CinemaNapoli/Reindirizzamento">Annulla</a>
	</div>
</div>