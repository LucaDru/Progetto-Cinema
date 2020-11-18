<%@page import="java.time.LocalDate"%>
<%@page import="model.Film"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MM-Ricerca Film</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">

<link rel="stylesheet" href="/CinemaNapoli/Home/css/ciaobea.css">
<link rel="stylesheet" href="/CinemaNapoli/Home/css/login.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Cantarell&family=Montserrat&display=swap"
	rel="stylesheet">
</head>
<body class="coloriamo">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>

	<jsp:include page="login.jsp"></jsp:include>
	<input type="hidden" id="controllo"
		value="<%=request.getAttribute("controllo") != null ? request.getAttribute("controllo") : 0%>">
	<input type="hidden"
		value="<%=request.getSession().getAttribute("userLoggato") != null ? 1 : 0%>"
		id="userLog">
	<div class="row mx-0 my-3">
		<div class="col-2"></div>
		<div class="col-8">
			<h4 style="text-align: center;">Ricerca avanzata</h4>
			<div class="mt-5 d-flex justify-content-center">
				<form action="RicercaFilm" class="form-inline" method="POST">
					<div class="form-group mr-4">

						<input class="form-control" type="text" name="titolo"
							placeholder="titolo">

					</div>
					<div class="form-group mr-4">
						<input class="form-control" type="date" name="data"
							min="<%=LocalDate.now()%>">


					</div>
					<div class="form-group col-1">
						<button type="submit" class="btn mb-0 " style="background-color:#150523; color:white">Filtra</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<jsp:include page="cardSpecFilm.jsp"></jsp:include>

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

	<script src="/CinemaNapoli/Home/js/scriptLogin.js"></script>
	<script src="/CinemaNapoli/Home/js/validateScript.js"></script>
	<script src="/CinemaNapoli/Home/js/controlloLog.js"></script>
</body>
</html>