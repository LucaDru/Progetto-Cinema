<%@page import="model.Genere"%>
<%@page import="java.util.List"%>
<%
	List<Genere> lista=(List<Genere>)request.getAttribute("listaGenere");
%>
<div class="card my-5 p-4">
	<h4>Elenco Account da attivare:</h4>
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
					if(request.getParameter("modificaGenere") != null &&
						Integer.parseInt(request.getParameter("modificaGenere")) 
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
							 value="<%= g.getNome() %>">	
						</div>	
					</td>
					<td>
						<div class="form-group">
							<input type="text" name="img"
							 value="<%= g.getImg() %>">
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
					<form action="VisualizzaListe" method="post">
						<input type="hidden" name="modificaGenere" value="<%=g.getId()%>">
						<button class="btn btn-info btn-sm"
						 	type="submit">Modifica</button>
					</form>
				</td>
			</tr>
			<%
				}}
			%>
		</tbody>
	</table>
</div>
</div>