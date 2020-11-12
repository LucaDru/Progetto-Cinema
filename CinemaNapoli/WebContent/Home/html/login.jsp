<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" style="text-align: center;"
					id="exampleModalLongTitle">Login</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!--form di login-->
				<form action="Login" method="post" class="form-signin" novalidate>
					<div class="text-center mb-4">
						<img class="mb-4" src="/CinemaNapoli/Home/res/Medea-Logo.png" alt="logo" width="100"
							height="100">
					</div>

					<div class="form-label-group">
						<input type="text" name="username" id="inputEmail" class="form-control"
							placeholder="Username" required autofocus> <label
							for="inputEmail">Username</label>
						<div class="invalid-feedback">Please provide a valid email.
						</div>
					</div>

					<div class="form-label-group">
						<input type="password" name="password" id="inputPassword" class="form-control"
							placeholder="Password" required> <label
							for="inputPassword">Password</label>
						<div class="invalid-feedback">Please provide a valid
							password.</div>
					</div>

					<div class="checkbox mb-3">
						<label> <input type="checkbox" value="remember-me">
							Ricordami
						</label>
					</div>
					<button class="btn btn-lg btn-secondary btn-block" type="submit">Sign
						in</button>
					<p class="mt-5 mb-3 text-muted text-center">&copy; 2020</p>
				</form>
			</div>
			<div class="modal-footer">
				<h4>
					Non hai un account? <a href="/CinemaNapoli/Home/html/Registrazione.jsp">Registrati!</a>
				</h4>
			</div>
		</div>
	</div>
</div>