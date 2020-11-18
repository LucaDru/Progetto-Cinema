<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%	
	List <Prenotazione> attive= (List<Prenotazione>) request.getAttribute("listaAttive");
	List <Prenotazione> passate= (List<Prenotazione>) request.getAttribute("listaPassate");
	User u=(User)request.getSession().getAttribute("userLoggato");
%>

<!-- prenotazioni in corso-->
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2" style="color: whitesmoke;">Ciao <%=u.getNome()%></h1>
	<!-- <br> <br>
	<h1 style="color: whitesmoke;">Bentornato NomeUtente</h1> -->
</div>
	<div class="card my-5 p-4">
		<br>
		<h2 class="ml-2">Le tue prenotazioni in corso:</h2>

		<table class="table table-striped">
			<thead style="border-top: none;">
				<tr>
					<th scope="col"></th>
					<th scope="col">Codice prenotazione <i class="fas fa-sort"
						id="ordineNumero"></i></th>
					<th scope="col">Titolo film <i class="fas fa-sort"
						id="ordineTitolo"></i></th>
					<th scope="col">Durata <i class="fas fa-sort" id="ordineDurata"></i></th>
					<th scope="col">Giorno <i class="fas fa-sort" id="ordineGiorno"></i></th>
					<th scope="col">Orario <i class="fas fa-sort" id="ordineOrario"></i></th>
					<th scope="col">Posti prenotati <i class="fas fa-sort"
						id="ordinePosti"></i></th>
					<th scope="col">...</th>
					<!-- bottone-->
				</tr>
			</thead>
			<tbody>
				<%
					for(Prenotazione p:attive){				
				%>
				<tr class="riga">
					<th scope="row"></th>
					<td class="col-numero codicino"><%=p.getBiglietto()%></td>
					<td class="col-titolo"><%=p.getProiezione().getFilm().getTitolo()%></td>
					<td class="col-durata"><%=p.getProiezione().getFilm().getDurata()%></td>
					<td class="col-giorno"><%=p.getProiezione().getData()%></td>
					<td class="col-ora"><%=p.getProiezione().getOra()%></td>
					<td class="col-posti"><%=p.getNumPosti()%></td>
					<td class="col-button">
						<form action="/CinemaNapoli/AnnullaPrenotazione" method="post">
							<input type="hidden" name="prenotazione" value="<%=p.getId()%>">
							<button type="submit" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top" title="Annulla">
                   				<i class="far fa-trash-alt"></i>
                  			</button>
                  		</form>
					</td>
				</tr>
				<%
					}				
				%>
			</tbody>
		</table>
	</div>
	<div class="card my-5 p-4">
		<br>
		<h2 class="ml-2">Le tue prenotazioni scadute:</h2>
		<table class="table table-striped">
			<thead style="border-top: none;">
				<tr>
					<th scope="col"></th>
					<th scope="col">Numero prenotazione <i class="fas fa-sort"
						id="ordineNumeroPast"></i></th>
					<th scope="col">Titolo film <i class="fas fa-sort"
						id="ordineTitoloPast"></i></th>
					<th scope="col">Durata<i class="fas fa-sort"
						id="ordineDurataPast"></i></th>
					<th scope="col">Giorno<i class="fas fa-sort"
						id="ordineGiornoPast"></i></th>
					<th scope="col">Orario<i class="fas fa-sort"
						id="ordineOrarioPast"></i></th>
					<th scope="col">Posti prenotati<i class="fas fa-sort"
						id="ordinePostiPast"></i></th>
				</tr>
			</thead>
			<tbody>
				<%
					for(Prenotazione p:passate){				
				%>
				<tr class="riga">
					<th scope="row"></th>
					<td class="col-numero-past"><%=p.getBiglietto()%></td>
					<td class="col-titolo-past"><%=p.getProiezione().getFilm().getTitolo()%></td>
					<td class="col-durata-past"><%=p.getProiezione().getFilm().getDurata()%></td>
					<td class="col-giorno-past"><%=p.getProiezione().getData()%></td>
					<td class="col-ora-past"><%=p.getProiezione().getOra()%></td>
					<td class="col-posti-past"><%=p.getNumPosti()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
