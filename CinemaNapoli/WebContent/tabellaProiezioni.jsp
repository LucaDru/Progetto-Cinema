<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%
	List<Proiezione> listaPro = (List<Proiezione>) request.getAttribute("listaProiezioni");
%>
<div class="container">
	<table class="table table-sm table-hover table-dark">
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
			%>
			<tr>
				<th scope="row"><%=listaPro.indexOf(p) + 1%></th>
				<td><%=p.getFilm().getTitolo()%></td>
				<td><%=p.getFilm().getDurata()+" min."%></td>
				<td><%=p.getData()%></td>
				<td><%=p.orarioSenzaSecondi()%></td>
				<td><%="sala "+p.getSala().getNome()%></td>
				<td><%=p.getPrezzo()+" "%>&euro;</td>
				<td>
				<%
					User u=(User)request.getSession().getAttribute("userLoggato");
					if(u!=null && u.getRuolo().getNome().equals("admin")){ 
				%>
					<a class="btn btn-outline-danger btn-sm" href="#"
					role="button">X</a>
				<% } else { %>
					<a class="btn btn-outline-success btn-sm" href="#"
					role="button">Prenota</a>
				<% } %>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>