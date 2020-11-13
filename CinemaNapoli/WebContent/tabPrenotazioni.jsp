<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%
	
	List <Prenotazione> attive= (List<Prenotazione>) request.getAttribute("listaAttive");
	List <Prenotazione> passate= (List<Prenotazione>) request.getAttribute("listaPassate");
%>

<div class="container">
	<h1>Prenotazioni In Corso</h1>
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
				for(Prenotazione p:attive){
					
				
			%>
			
			<!-- Lista proiezioni -->
			<tr>
				<th scope="row"><%=attive.indexOf(p) + 1%></th>
				<td><%=p.getProiezione().getFilm().getTitolo()%></td>
				<td><%=p.getProiezione().getData()%></td>
				<td><%=p.getProiezione().orarioSenzaSecondi()%></td>
				<td><%=p.getNumPosti()%></td>


				<td>
					<form action="AnnullaPrenotazione" method="post">
						<input type="hidden" name="prenotazione" value="<%=p.getId()%>">
						<button class="btn btn-success btn-sm" role="submit">Annulla
							Prenotazione</button>
					</form>
				</td>
			</tr>
			<%
				}
			
			%>
		</tbody>

	</table>

	<h1>Prenotazioni Passate</h1>
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
				for(Prenotazione p:passate){
					
				
			%>
			<tr>
				<th scope="row"><%=passate.indexOf(p) + 1%></th>
				<td><%=p.getProiezione().getFilm().getTitolo()%></td>
				<td><%=p.getProiezione().getData()%></td>
				<td><%=p.getProiezione().orarioSenzaSecondi()%></td>
				<td><%=p.getNumPosti()%></td>
	
			</tr>
			
			<%} %>

		</tbody>
	</table>
	
</div>