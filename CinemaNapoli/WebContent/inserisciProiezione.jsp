<%@page import="static util.GestisciDatabase.*"%>
<%@page import="model.Sala"%>
<%@page import="model.Film"%>
<%@page import="java.util.List"%>

<div class="container">
		<form action="InserimentoProiezione" method="post">
			<div class="form-group">
				<label for="exampleInputData">Data</label> <input
					name="data" type="date" class="form-control"> 
			</div>
			<div class="form-group">
				<label for="exampleInputOra">Ora</label> <input
					name="ora" type="time" class="form-control">
			</div>
			<div class="form-group">
				<label for="exampleInputPrezzo">Prezzo</label> <input
					name="prezzo" type="number" min="1" step="any" class="form-control">
			</div>
		
		<!-- Film tab -->	
			<div
			class="tab-pane fade bg-dark text-warning justify-content-center text-center"
			id="film" role="tabpanel" aria-labelledby="film-tab">

			<hr class="bg-warning">
			<p>Elenco Film</p>
			<hr>
			<div class="container" id="elenco-film">
				<div class="card card-body">
					<%
						List<Film> listaFilm = leggiFilm();
					%>
					<table class="table table-sm table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Titolo</th>
								<th scope="col">Locandina</th>
								<th scope="col">Durata</th>
								<th scope="col">Anno di uscita</th>
								<th scope="col">...</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Film f : listaFilm) {
							%>
							<tr>
								<th scope="row"><%=listaFilm.indexOf(f)+1%></th>
								<td><%=f.getTitolo()%></td>
								<td><%=f.getLocandina()%></td>
								<td><%=f.getDurata()%></td>
								<td><%=f.getAnnouscita()%></td>
								<td>
									<a class="btn btn-outline-success btn-sm" href="InserimentoProiezione?idFilm=<%=f.getId()%>" role="button">Inserisci</a>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
			<!-- Sala tab -->	
			<div
			class="tab-pane fade bg-dark text-warning justify-content-center text-center"
			id="sala" role="tabpanel" aria-labelledby="sala-tab">

			<hr class="bg-warning">
			<p>Elenco Sale</p>
			<hr>
			<div class="container" id="elenco-sale">
				<div class="card card-body">
					<%
						List<Sala> listaSale = leggiSala();
					%>
					<table class="table table-sm table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nome</th>
								<th scope="col">...</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Sala s : listaSale) {
							%>
							<tr>
								<th scope="row"><%=listaSale.indexOf(s)+1%></th>
								<td><%=s.getNome()%></td>
								<td>
									<a class="btn btn-outline-success btn-sm" href="InserimentoProiezione?idSala=<%=s.getId()%>" role="button">Inserisci</a>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
			<button type="submit" class="btn btn-primary">Aggiungi Proiezione</button>
			
		</form>
	</div>

	