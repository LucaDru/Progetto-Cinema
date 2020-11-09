<%@page import="model.Genere"%>
<%@page import="java.util.List"%>

<%
	List<Genere> lista=(List<Genere>)request.getAttribute("listaGenere");
%>
<div class="container">
	<table class="table table-sm table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">Locandina</th>
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
						<button type="submit" class="btn btn-primary"> Modifica </button>
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
					<a class="btn btn-info" href="VisualizzaListe?modifica=<%=g.getId() %>"
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