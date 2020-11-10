<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%
	List<User> listaCancellati = (List<User>)request.getAttribute("listaCancellati");
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
				for (User u : listaCancellati) {
			%>
			<tr>
				<th scope="row"><%=listaCancellati.indexOf(u) + 1%></th>
				<td><%=u.getNome()%></td>
				<td><%=u.getCognome()%></td>
				<td>
					<a class="btn btn-outline-info btn-sm" href="AttivazioneAccount?attiva=<%=u.getId()%>" role="button">
						Attiva</a>
					<a class="btn btn-outline-info btn-sm"
					href="ResetPassword?reset=<%=u.getId()%>" role="button">Reset
						Password</a>
					<a class="btn btn-outline-danger btn-sm" href="AssegnaRuoli?bannato=<%=u.getId()%>" role="button">
						Bann</a>					
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>