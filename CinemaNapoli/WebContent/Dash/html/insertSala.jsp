<div class="jumbotron collapse" id="inserisci-sala">
	<div class="container">
		<form action="InserisciSala" method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Nome</label> 
					<input name="nome" type="text" class="form-control" id="inputEmail4" required>
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Posti</label> 
					<input name="posti" type="number" min="10" max="200" step="10" class="form-control" id="inputPassword4" required>
				</div>
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1"
					name="treD"> <label class="form-check-label"
					for="exampleCheck1">3D</label>
			</div>
			<div class="align-items-center">
				<button type="submit" class="btn btn-primary">aggiungi</button>
			</div>
		</form>
	</div>
</div>
