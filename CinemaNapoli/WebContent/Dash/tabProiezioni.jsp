<%@page import="model.Sala"%>
<%@page import="model.Film"%>
<%@page import="model.Proiezione"%>
<%@page import="java.util.List"%>
<%
	List<Proiezione> listaPro = (List<Proiezione>)request.getAttribute("listaProiezioni");
	List<Sala> listaSale = (List<Sala>)request.getAttribute("listaSale");
	List<Film> listaFilm = (List<Film>)request.getAttribute("listaFilm");
%>
<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titolo</th>
				<th scope="col">Durata</th>
				<th scope="col">Data</th>
				<th scope="col">Ora</th>
				<th scope="col">Sala</th>
				<th scope="col">Prezzo</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Proiezione p:listaPro) {
					if(request.getParameter("modificaProiezione") != null &&
							Long.parseLong(request.getParameter("modificaProiezione")) 
							== p.getId()) {
			%>
		<!-- Modifica proiezione -->	
		<form action="ModificaProiezione" method="post">	
			<tr>
					<th scope="row"><%= listaPro.indexOf(p)+1%> <input type="hidden"
						name="id" value="<%=p.getId()%>"></th>
					<td>
						<div class="form-group">
							<select class="custom-select" id="filmetti" name="film">
								<option selected value="<%=p.getFilm().getId()%>"><%=p.getFilm().getTitolo()%></option>
								<%
									for (Film f : listaFilm) {
								%>
								<option value="<%=f.getId()%>"><%=f.getTitolo() + " " + f.getAnnouscita()%></option>
								<%
									}
								%>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group">
							<input type="date" name="data" value="<%= p.getData() %>">
						</div>
					</td>
					<td>
						<div class="form-group">
							<input type="time" name="ora" value="<%= p.getOra() %>">
						</div>
					</td>
					<td>
						<div class="form-group">
							<select class="custom-select" id="salette" name="sala">
								<option selected value="<%=p.getSala().getId()%>"><%=p.getSala().getNome()%></option>
								<%
									for (Sala s : listaSale) {
								%>
								<option value="<%=s.getId()%>"><%=s.getNome()%></option>
								<%
									}
								%>
							</select>
						</div>
					</td>
					<td>
						<div class="form-group">
							<input type="number" name="prezzo"  min="1" step="any" value="<%= p.getPrezzo() %>">
						</div>
					</td>
					<td>
						<button type="submit" class="btn btn-primary btn-sm">Modifica</button>
					</td>
				</tr>
			</form>
			
			<%
					} else {
			%>
		
		<!-- Lista proiezioni -->
			<tr>
				<th scope="row"><%=listaPro.indexOf(p) + 1%></th>
				<td><%=p.getFilm().getTitolo()%></td>
				<td><%=p.getFilm().getDurata()+" min."%></td>
				<td><%=p.getData()%></td>
				<td><%=p.orarioSenzaSecondi()%></td>
				<td><%="sala "+p.getSala().getNome()%></td>
				<td><%=p.getPrezzo()+" "%>&euro;</td>
				<td>
					<a class="btn btn-info btn-sm" href="VisualizzaListe?dash=proiezioni&modificaProiezione=<%=p.getId() %>"
					 	role="button">Modifica</a>
					<a class="btn btn-outline-danger btn-sm" href="#"
					role="button">X</a>
				</td>
			</tr>
			<%
				}}
			%>
		</tbody>
	</table>
</div>