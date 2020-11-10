<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    	
    <!-- CSS -->
	<link href="Dash/css/dashboard.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="navOriz.jsp"></jsp:include>
	
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="navVert.jsp"></jsp:include>
		</div>
		
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
			
			<div class="pt-3 pb-2 mb-3 border-bottom text-center">
          		<button class="btn btn-warning" type="button" data-toggle="collapse"
					data-target="#inserisci-film" aria-expanded="false"
					aria-controls="collapseExample">Inserisci Film</button>
				<button class="btn btn-warning" type="button" data-toggle="collapse"
					data-target="#inserisci-genere" aria-expanded="false"
					aria-controls="collapseExample">Inserisci Genere</button>
          	</div>
          	<jsp:include page="insertFilm.jsp"></jsp:include>
          	<jsp:include page="insertGenere.jsp"></jsp:include>
		
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          		<h1 class="h2">Generi</h1>
          	</div>
          	<jsp:include page="tabGenere.jsp"></jsp:include>
			
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          		<h1 class="h2">Film</h1>
          	</div>
          	<jsp:include page="tabFilm.jsp"></jsp:include>
		</main>
	</div>
	
	<!-- SCRIPT NO RITORNO -->
	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
	</script>
	<!-- BootStrap -->
  	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    	crossorigin="anonymous"></script>
  	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    	crossorigin="anonymous"></script>
</body>
</html>