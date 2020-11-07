<%@page import="model.Film"%>
<%@page import="java.util.List"%>
<%
	List<Film> listaFilm = (List<Film>) request.getAttribute("listaFilm");
%>
<div class="container">
	<table class="table table-sm table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titolo</th>
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
				<th scope="row"><%=listaFilm.indexOf(f) + 1%></th>
				<td><%=f.getTitolo()%></td>
				<td><%=f.getDurata()%></td>
				<td><%=f.getAnnouscita()%></td>
				<td>
					<a class="btn btn-outline-danger btn-sm" href="#"
					role="button">X</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>