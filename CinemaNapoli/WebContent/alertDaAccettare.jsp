<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina di Conferma</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body class="bg-dark">
	<div class="container text-center">
		
			<%
				if(request.getAttribute("bannato")!=null){
			%>
				<div class="alert alert-danger text-center my-5" role="alert">
					<h1>
						Questo account è stato BANNATO.
					</h1>
				</div>
			<%
				} else if(request.getAttribute("attivo")!=null) { 
			%>
				<div class="alert alert-info text-center my-5" role="alert">
					<h1>
						Questo account è stato cancellato. Contatta un Admin se lo vuoi riattivare.
					</h1>
				</div>
			<% 
				}else{
			%>
				<div class="alert alert-warning text-center my-5" role="alert">
					<h1>
						Questo account ancora non è attivo, a breve verrà confermato da un Admin.
					</h1>
				</div>
			<% 
				}
			%>
		
		<div class="my-4 text-center">
			<a href="/CinemaNapoli/Home/html/Home.jsp">Torna alla Home</a>
		</div>
	</div>
	
	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>