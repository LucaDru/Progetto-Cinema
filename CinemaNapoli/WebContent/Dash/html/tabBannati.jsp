<%@page import="java.util.List"%>
<%@page import="model.User"%>

<%
	List<User> listaBannati = (List<User>)request.getAttribute("listaBannati");
%>
<div class="card my-5 p-4">
	<h4>Elenco Account bannati:</h4>
	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome <i class="fas fa-sort"></i></th>
					<th>Cognome <i class="fas fa-sort"></i></th>
					<th>Email <i class="fas fa-sort"></i></th>
					<th>...</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (User u : listaBannati) {
				%>
				<tr>
					<th><button type="button" class="btn btn-secondary btn-sm"
							data-toggle="tooltip" data-placement="top" title="Maggiori Info">
							<i class="fas fa-plus"></i>
						</button></th>
					<td class="p-2"><%=u.getNome()%></td>
					<td class="p-2"><%=u.getCognome()%></td>
					<td class="p-2"><%=u.getEmail()%></td>
					
					<td>
						<form action="AssegnaRuoli" method="post">
							<input type="hidden" name="user" value="<%=u.getId()%>">
							<button type="submit" class="btn btn-primary btn-sm"
								data-toggle="tooltip" data-placement="top" title="Sbanna">
								<i class="fas fa-thumbs-up"></i>
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
</div>