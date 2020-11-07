<%@page import="model.Sala"%>
<%@page import="java.util.List"%>

<%
	List<Sala> lista=(List<Sala>)request.getAttribute("listaSale");
%>

<div class="container">
	<table class="table table-sm table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">N° posti</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Sala s : lista) {
			%>
			<tr>
				<th scope="row"><%=lista.indexOf(s) + 1%></th>
				<td><%=s.getNome()%></td>
				<td><%=s.getPostiMax()%></td>
				<td><a class="btn btn-outline-danger btn-sm" href="#"
					role="button">X</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>