<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%
	User u=(User)request.getSession().getAttribute("userLoggato");
	List<Prenotazione> lista=u.getPrenotazioni();
%>

<div class="container">
	<table class="table table-sm table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titolo</th>
				<th scope="col">Data</th>
				<th scope="col">Ora</th>
				<th scope="col">n° posti</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Prenotazione p:lista) {
			%>	
				<!-- Lista proiezioni -->
			<tr>
				<th scope="row"><%=lista.indexOf(p) + 1%></th>
				<td><%=p.getProiezione().getFilm().getTitolo()%></td>
				<td><%=p.getProiezione().getData()%></td>
				<td><%=p.getProiezione().orarioSenzaSecondi()%></td>
				<td><%=p.getNumPosti()%></td>
				<td>
					<form action="AnnullaPrenotazione" method="post">
						<input type="hidden" name="prenotazione" value="<%=p.getId()%>">
						<button class="btn btn-success btn-sm" role="submit">Annulla Prenotazione</button>
					</form>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>