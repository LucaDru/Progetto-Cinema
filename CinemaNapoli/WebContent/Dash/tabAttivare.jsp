<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%
	List<User> listaAccettare = (List<User>)request.getAttribute("listaAccettare");
%>
<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">Cognome</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (User u : listaAccettare) {
			%>
			<tr>
				<th scope="row"><%=listaAccettare.indexOf(u) + 1%></th>
				<td><%=u.getNome()%></td>
				<td><%=u.getCognome()%></td>
				<td>
					<a class="btn btn-outline-info btn-sm" href="AssegnaRuoli?user=<%=u.getId()%>" role="button">
						Attiva</a>										
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>