<%@page import="model.Genere"%>
<%@page import="java.util.List"%>



<div class="container">
	<form action="InserisciGenere" method="post">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputEmail4">Genere</label> <input name="nomeGenere"
					type="text" class="form-control" id="inputEmail4">
					
			</div>
			<div class="form-group">
				<label for="exampleInputLocandina">Immagine di copertina</label> <input
					name="file" type="file" class="form-control">
			</div>

		</div>
		<div class="align-items-center">
			<button type="submit" class="btn btn-primary">aggiungi</button>
		</div>
	</form>
</div>

