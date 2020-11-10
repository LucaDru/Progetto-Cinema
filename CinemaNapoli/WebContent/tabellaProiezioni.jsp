<%@page import="model.Sala"%>
<%@page import="model.Film"%>
<%@page import="model.Proiezione"%>
<%@page import="java.util.List"%>
<%
	List<Proiezione> listaPro = (List<Proiezione>) request.getAttribute("listaProiezioni");
	List<Sala> listaSale = (List<Sala>) request.getAttribute("listaSale");
	List<Film> listaFilm = (List<Film>) request.getAttribute("listaFilm");
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
					<a class="btn btn-success btn-sm" 
						href="<%=request.getSession().getAttribute("userLoggato")!=null?"ControlloFatturazione?id="+p.getId():"home.jsp"%>"
					 	role="button">Prenota</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>