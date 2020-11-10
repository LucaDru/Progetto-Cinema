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
				<th scope="col">N� posti</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Sala s : lista) {
					if(request.getParameter("modifica") != null &&
						Long.parseLong(request.getParameter("modifica")) 
						== s.getId()) {
			%>
		<!-- Modifica sala -->	
			<form action="ModificaSala" method="post">
				<tr>
					<th scope="row"><%= lista.indexOf(s)+1%> 
					<input type="hidden" name= "id" value="<%=s.getId()%>">
					</th>
					
					<td>
						<div class="form-group">
							<input type="text" name="nome"
							 value=<%= s.getNome() %>>	
						</div>	
					</td>
					<td>
						<div class="form-group">
							<input type="number" name="postimax"
							 value=<%= s.getPostiMax() %>>
						</div>
					</td>
					<td>
						<button type="submit" class="btn btn-primary"> Modifica </button>
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
					<a class="btn btn-info" href="VisualizzaListe?modifica=<%=s.getId() %>"
					 	role="button">Modifica</a>
					<a class="btn btn-outline-danger btn-sm" href="#"
						role="button">X</a>
				</td>
			</tr>
			<%
				}}
			%>
		</tbody>
	</table>
</div>