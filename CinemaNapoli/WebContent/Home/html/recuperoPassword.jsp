<div class="modal fade" id="recupero-password" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" style="text-align: center;"
					id="exampleModalLongTitle">Recupera Password</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!--form di login-->
				<form action="/CinemaNapoli/ResetPassword" method="post" class="form-signin"
					novalidate>
					<div class="text-center mb-4">
						<img class="mb-4" src="/CinemaNapoli/Home/res/Medea-Logo-prugna.png" alt="logo"
							width="160" height="160">
					</div>

					<div class="form-label-group">
						<input type="email" id="inputEmail" class="form-control"
							placeholder="Indirizzo email" name="email" required autofocus> <label
							for="inputEmail">Indirizzo email</label>
						<div class="invalid-feedback">Inserisci una mail valida.</div>
					</div>

					<div class="form-label-group">
						<input type="text" id="inputPassword" class="form-control"
							placeholder="username" name="username" required> <label
							for="inputPassword">username</label>
						<div class="invalid-feedback">Inserisci un username valido.
						</div>
					</div>


					<button class="btn btn-lg btn-secondary btn-block" type="submit">Recupera</button>

				</form>
			</div>
		</div>
	</div>
</div>