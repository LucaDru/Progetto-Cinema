

<%@page import="java.util.List"%>
<%@page import="model.Genere"%>
<%
	List <Genere> lista=(List <Genere>)request.getAttribute("listaGenere");
%>
<div class="container">
	<form action="InserisciFilm" enctype="multipart/form-data"
		method="post">
		<div class="form-group">
			<label for="exampleInputTitolo">Titolo</label> <input name="titolo"
				type="text" class="form-control">
		</div>
		<select class="custom-select" id="genere" name="genere" required>
					<option selected>Scegli Genere</option>
					<%
					
						for (Genere g : lista) {
					%>
					<option value="<%=g.getId()%>"><%=g.getNome()%></option>
					<%
						}
					%>
		</select>			
		<div class="form-group">
			<label for="exampleInputLocandina">Locandina</label> <input
				name="file" type="file" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputTrama">Trama</label> <input name="trama"
				type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputDurata">Durata</label> <input name="durata"
				type="text" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputAnno">Anno di uscita</label> <input
				name="annouscita" type="text" class="form-control">
		</div>
		<button type="submit" class="btn btn-primary">Aggiungi Film</button>
	</form>
</div>