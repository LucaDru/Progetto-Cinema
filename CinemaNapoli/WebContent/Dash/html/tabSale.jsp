<%@page import="model.Sala"%>
<%@page import="java.util.List"%>

<%
	List<Sala> lista = (List<Sala>) request.getAttribute("listaSale");
%>
<div class="card my-5 p-4">
	<h4>Elenco Account da attivare:</h4>
	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">N° posti</th>
					<th scope="col">3D</th>
					<th scope="col">...</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Sala s : lista) {
					if (request.getParameter("modifica") != null && Long.parseLong(request.getParameter("modifica")) == s.getId()) {
				%>
				<!-- Modifica sala -->
				<form action="ModificaSala" method="post">
					<tr>
						<th scope="row"><%=lista.indexOf(s) + 1%> <input type="hidden"
							name="id" value="<%=s.getId()%>"></th>

						<td>
							<div class="form-group">
								<input type="text" name="nome" value=<%=s.getNome()%>>
							</div>
						</td>
						<td>
							<div class="form-group">
								<input type="number" name="postimax"
									value=<%=s.getPostiMax()%>>
							</div>
						</td>
						<td>
							<div class="form-group form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1" name="treD"> <label
									class="form-check-label" for="exampleCheck1">3D</label>
							</div>
						</td>
						<td>
							<button type="submit" class="btn btn-primary">Modifica</button>
						</td>
					</tr>
				</form>

				<%
					} else {
				%>

				<!-- Lista sale -->
				<tr>
					<th scope="row"><%=lista.indexOf(s) + 1%></th>
					<td><%=s.getNome()%></td>
					<td><%=s.getPostiMax()%></td>
					<td>
						<%
							if (s.isTreD()) {
						%>
						<div class="custom-control custom-switch d-inline p-2">
							<input type="checkbox" class="custom-control-input"
								id="customSwitch2" checked disabled> <label
								class="custom-control-label" for="customSwitch2"></label>
						</div> <%
 	} else {
 %>
						<div class="custom-control custom-switch d-inline p-2">
							<input type="checkbox" class="custom-control-input"
								id="customSwitch2" disabled> <label
								class="custom-control-label" for="customSwitch2"></label>
						</div> <%
 	}
 %>
					</td>
					<td><a class="btn btn-info"
						href="VisualizzaListe?modifica=<%=s.getId()%>" role="button">Modifica</a>
						<a class="btn btn-outline-danger btn-sm" href="#" role="button">X</a>
					</td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
	</div>
</div>