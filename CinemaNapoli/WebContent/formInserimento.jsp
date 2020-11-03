<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>

<form>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Nome</label>
      <input name ="nome" type="nome" class="form-control" id="inputEmail4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Cognome</label>
      <input name="cognome" type="cognome" class="form-control" id="inputPassword4">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Data di nascita</label>
    <input name="datadinascita" type="date" class="form-control" id="inputAddress" placeholder="anno/mese/giorno">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Citta</label>
    <input name= "citta" type="text" class="form-control" id="inputAddress2">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Provincia</label>
      <input name="provincia" type="text" class="form-control" id="inputCity">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">Indirizzo</label>
      <input name="indirizzo" type="text" class="form-control" id="inputCity">
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Cap</label>
      <input name="cap" type="text" class="form-control" id="inputZip">
    </div>
     <div class="form-group col-md-2">
      <label for="inputZip">Codice Fiscale</label>
      <input name="cf" type="text" class="form-control" id="inputZip">
    </div>
     <div class="form-group col-md-2">
      <label for="inputZip">Partita Iva</label>
      <input name="piva" type="text" class="form-control" id="inputZip">
    </div>
     <div class="form-group col-md-2">
      <label for="inputZip">E-mail</label>
      <input name="email" type="text" class="form-control" id="inputZip">
    </div>
     <div class="form-group col-md-2">
      <label for="inputZip">Username</label>
      <input name="username" type="text" class="form-control" id="inputZip">
    </div>
     <div class="form-group col-md-2">
      <label for="inputZip">Password</label>
      <input name="password" type="text" class="form-control" id="inputZip">
    </div>
  </div>
  <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck">
      <label class="form-check-label" for="gridCheck">
        Check me out
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Sign in</button>
</form>



<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>