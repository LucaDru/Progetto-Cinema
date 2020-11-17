<%@page import="java.util.List"%>
<%@page import="model.User"%>

<%
	List<User> listaCancellati = (List<User>)request.getAttribute("listaCancellati");
%>
<div class="card my-5 p-4">
	<h4>Elenco Account cancellati:</h4>
	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome <i class="fas fa-sort"></i></th>
					<th>Cognome <i class="fas fa-sort"></i></th>
					<th>Email <i class="fas fa-sort"></i></th>
					<th>Staff</th>
					<th>...</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (User u : listaCancellati) {
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
						<div class="custom-control custom-switch d-inline p-2">
							<input type="checkbox" class="custom-control-input"
								id="customSwitch2" checked disabled> <label
								class="custom-control-label" for="customSwitch2"></label>
						</div>
						<button type="button" class="btn btn-warning btn-sm"
							data-toggle="tooltip" data-placement="top"
							title="Promuovi/Demota">
							<i class="fas fa-exchange-alt"></i>
						</button>
					</td>
					<td>
						<button type="button" class="btn btn-primary btn-sm"
							data-toggle="tooltip" data-placement="top" title="Accetta">
							<i class="fas fa-thumbs-up"></i>
						</button>
						<button type="button" class="btn btn-danger btn-sm"
							data-toggle="tooltip" data-placement="top" title="Banna">
							<i class="fas fa-ban"></i>
						</button>						
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>