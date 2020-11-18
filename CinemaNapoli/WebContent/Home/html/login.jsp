<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" style="text-align: center;"
					id="exampleModalLongTitle">Login</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" id="chiudi-modale">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!--form di login-->
				<form action="/CinemaNapoli/Login" method="post" class="form-signin"
					novalidate>
					<div class="text-center mb-4">
						<img class="mb-4" src="/CinemaNapoli/Home/res/Medea-Logo-prugna.png"
							alt="logo" width="160" height="160">
					</div>

					<div class="form-label-group">
						<input type="text" name="username" id="inputEmail"
							class="form-control" placeholder="Username" required autofocus>
						<label for="inputEmail">Username</label>
						<div class="invalid-feedback">Immettere una mail valida.
						</div>
					</div>

					<div class="form-label-group">
						<input type="password" name="password" id="inputPassword"
							class="form-control" placeholder="Password" required> <label
							for="inputPassword">Password</label>
						<div class="invalid-feedback">Immettere una	password valida.</div>
					</div>
					<%
						if (request.getAttribute("sbagliato") != null) {
					%>
					<div class="alert alert-danger" role="alert">Nome
						Utente/password errati.</div>
					<%
						}
					%>

					
					<div class="checkbox mb-3">
						<label> <input type="checkbox" name="ricordami">
							Ricordami
						</label>
					</div>
					<button class="btn btn-lg btn-secondary btn-block" type="submit">Login</button>
					<p class="mt-5 mb-1 text-muted text-center"><a href="#" id="pwd-dimenticata">Password dimenticata?</a></p>
				</form>
			</div>
			<div class="text-center border-top py-4">
				<h4>
					Non hai un account? 
					<a href="/CinemaNapoli/Home/html/registrazioneFinale.jsp">Registrati!</a>
				</h4>
			</div>
		</div>
	</div>
</div>