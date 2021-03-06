<%@page import="model.Sala"%>
<%@page import="model.Film"%>
<%@page import="java.util.List"%>
<%
	List<Sala> listaSale = (List<Sala>)request.getAttribute("listaSale");
	List<Film> listaFilm = (List<Film>)request.getAttribute("listaFilm");
%>

<div class="jumbotron collapse" id="inserisci-proiezione">
	<form action="InserimentoProiezione" method="post">
		<div class="form-row">
			<div class="form-group col-md-6">
				<div class="input-group-prepend">
					<label class="input-group-text" for="filmetti">Film</label>
				</div>
				<select class="custom-select" id="filmetti" name="film">
					<option selected>Scegli Film</option>
					<%
						for (Film f : listaFilm) {
					%>
					<option value="<%=f.getId()%>"><%=f.getTitolo() + " " + f.getAnnouscita()%></option>
					<%
						}
					%>
				</select>
			</div>
			<div class="form-group col-md-6">
				<div class="input-group-prepend">
					<label class="input-group-text" for="salette">Film</label>
				</div>
				<select class="custom-select" id="salette" name="sala">
					<option selected>Scegli Sala</option>
					<%
						for (Sala s : listaSale) {
					%>
					<option value="<%=s.getId()%>"><%=s.getNome()%></option>
					<%
						}
					%>
				</select>
			</div>
		</div>
		<div class="form-row col-md-4">
			<div class="form-group">
				<label for="exampleInputData">Data</label> <input name="data"
					type="date" class="form-control" required>
			</div>
			<div class="form-group col-md-4">
				<label for="exampleInputOra">Ora</label> <input name="ora"
					type="time" class="form-control" required>
			</div>
			<div class="form-group col-md-4">
				<label for="exampleInputPrezzo">Prezzo</label> 
				<select class="custom-select" id="listaPrezzi" name="prezzo">
					<option selected>Scegli prezzo</option>
					<option value="2.0">2.0</option>
					<option value="7.5">7.5</option>
					<option value="10.0">10.0</option>
				</select>
			</div>
		</div>
		<div class="align-items-center">
			<button type="submit" class="btn btn-primary">Aggiungi
				Proiezione</button>
		</div>
	</form>

	<%
		if (request.getAttribute("dataSbagliata") != null) {
	%>
	<div class="alert alert-danger text-center" role="alert">Non puoi
		inserire una proiezione antecedente alla data di oggi!</div>
	<%
		} else if (request.getAttribute("orarioSbagliato") != null) {
	%>
	<div class="alert alert-danger text-center" role="alert">
		<%=request.getAttribute("orarioSbagliato")%>
	</div>
	<%
		}
	%>
</div>