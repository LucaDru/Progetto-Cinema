<%@page import="model.Genere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>categorie</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">

<link rel="stylesheet" href="/CinemaNapoli/Home/css/ciaobea.css">
<link rel="stylesheet" href="/CinemaNapoli/Home/css/login.css">
<link rel="stylesheet" href="/CinemaNapoli/Home/css/Cat.css">
</head>
<body>
	
	<%
		List<Genere>listaGeneri = (List<Genere>)request.getAttribute("listaGeneri");
	%>
	
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	
	<div class="container sfondocat">

		<h1 class="titolo-card">Genere</h1>
		<hr class="mt-2 mb-5">
		<div class="row m-0">
			
			<%
				for(Genere g: listaGeneri){
			
			%>
			
				<div class="card categoria col-2" style="width: 12rem;">
					<img class="card-img genereimg" src="<%=g.getImg()%>">
					<a href="#" class="d-block mb-4 h-100">
						<div class="testocard" ><%=g.getNome()%></div>
					</a>
				</div>
		
			<%
				}
			%>
		</div>
		
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- BootStrap -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>

	</body>
</html>