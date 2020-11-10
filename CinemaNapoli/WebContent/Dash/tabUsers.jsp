<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%
	List<User> listaUtenti = (List<User>)request.getAttribute("listaUser");
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
				for (User u : listaUtenti) {
			%>
			<tr>
				<th scope="row"><%=listaUtenti.indexOf(u) + 1%></th>
				<td><%=u.getNome()%></td>
				<td><%=u.getCognome()%></td>
				<td><a class="btn btn-outline-info btn-sm"
					href="ResetPassword?reset=<%=u.getId()%>" role="button">Reset
						Password</a> <a class="btn btn-outline-warning btn-sm"
					href="AssegnaRuoli?staff=<%=u.getId()%>" role="button">Staff</a> <a
					class="btn btn-outline-danger btn-sm"
					href="AssegnaRuoli?bannato=<%=u.getId()%>" role="button">Bann</a> <a
					class="btn btn-outline-danger btn-sm"
					href="AttivazioneAccount?disattiva=<%=u.getId()%>" role="button">X</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>