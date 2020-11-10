<%@page import="model.Genere"%>
<%@page import="java.util.List"%>
<%@page import="util.GestisciDatabase"%>
<%
	List<Genere> lista=GestisciDatabase.leggiGenere();
%>
<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">Locandina</th>
				<th scope="col">...</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Genere g : lista) {
					if(request.getParameter("modifica") != null &&
						Integer.parseInt(request.getParameter("modifica")) 
						== g.getId()) {
			%>
		<!-- Modifica genere -->	
			<form action="ModificaGenere" method="post">
				<tr>
					<th scope="row"><%= lista.indexOf(g)+1%> 
					<input type="hidden" name= "id" value="<%=g.getId()%>">
					</th>
					
					<td>
						<div class="form-group">
							<input type="text" name="nome"
							 value=<%= g.getNome() %>>	
						</div>	
					</td>
					<td>
						<div class="form-group">
							<input type="text" name="img"
							 value=<%= g.getImg() %>>
						</div>
					</td>
					<td>
						<button type="submit" class="btn btn-primary btn-sm"> Modifica </button>
					</td>
				</tr>
			</form>
			
			<%
					} else {
			%>
			
			<!-- Lista genere -->
			<tr>
				<th scope="row"><%=lista.indexOf(g) + 1%></th>
				<td><%=g.getNome()%></td>
				<td><%=g.getImg()%></td>
				<td> 
					<a class="btn btn-info btn-sm" href="VisualizzaListe?modifica=<%=g.getId() %>"
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