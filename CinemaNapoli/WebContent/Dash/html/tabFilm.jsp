<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%
	List<Film> listaFilm=(List<Film>)request.getAttribute("listaFilm");
	List<Genere> listaGenere=(List<Genere>)request.getAttribute("listaGenere");
%>
<div class="card my-5 p-4">
	<h4>Elenco Account da attivare:</h4>
<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titolo</th>
				<th scope="col">Genere</th>
				<th scope="col">Durata</th>
				<th scope="col">Anno di uscita</th>
				<th scope="col">Trama</th>
				<th scope="col">Locandina</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Film f : listaFilm) {
					if(request.getParameter("modificaFilm") != null &&
							Integer.parseInt(request.getParameter("modificaFilm")) 
							== f.getId()) {
			%>
				<form action="ModificaFilm" method="post">
				<tr>
					<th scope="row"><%= listaFilm.indexOf(f)+1%> 
					<input type="hidden" name= "id" value="<%=f.getId()%>">
					</th>
					
					<td>
						<div class="form-group">
							<input type="text" name="titolo"
							 value="<%= f.getTitolo() %>">	
						</div>	
					</td>
					<td>
						<select class="custom-select" id="genere" name="genere">
					<option selected value="<%=f.getGenere().getId()%>"><%=f.getGenere().getNome()%></option>
					<%
					
						for (Genere g : listaGenere) {
					%>
					<option value="<%=g.getId()%>"><%=g.getNome()%></option>
					<%
						}
					%>
				</select>
					</td>
					<td>
						<div class="form-group">
							<input type="number" name="durata"
							 value="<%= f.getDurata() %>">
						</div>
					</td>
					<td>
						<div class="form-group">
							<input type="number" name="annouscita"
							 value="<%= f.getAnnouscita() %>">
						</div>
					</td>
					<td>
						<div class="form-group">
							<input type="text" name="trama"
							 value="<%= f.getTrama() %>">
						</div>
					</td>
					<td>
						<div class="form-group">
							<input type="text" name="locandina"
							 value="<%= f.getLocandina() %>">
						</div>
					</td>
					<td>
						<button type="submit" class="btn btn-primary"> Modifica </button>
					</td>
				</tr>
			</form>
			
			<%
					} else {
			%>
			
			<tr>
				<th scope="row"><%=listaFilm.indexOf(f) + 1%></th>
				<td><%=f.getTitolo()%></td>

				<td><%=f.getGenere().getNome()%></td>
				<td><%=f.getDurata()%></td>
				<td><%=f.getAnnouscita()%></td>
				<td><%=f.getTrama()%></td>
				<td><%=f.getLocandina()%></td>
				<td> 
					<a class="btn btn-info btn-sm" href="VisualizzaListe?dash=film&modificaFilm=<%=f.getId()%>"
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
</div>