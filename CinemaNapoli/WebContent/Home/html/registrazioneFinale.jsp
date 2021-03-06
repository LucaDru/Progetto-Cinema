<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="/CinemaNapoli/Home/css/fontawesome-free-5.15.1-web/css/all.min.css">
	<link rel="stylesheet" href="/CinemaNapoli/Home/css/ciaobea.css">
	<link rel="stylesheet" href="/CinemaNapoli/Home/css/login.css">
	<link rel="stylesheet" href="/CinemaNapoli/Home/css/reg.css">
</head>
<body class="imgsfondo">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>

	<jsp:include page="login.jsp"></jsp:include>
	
	<div class="container">
    <div class="col-12 sfondo">
      <form id="regForm" action="/CinemaNapoli/Registrazione" method="post"> 

        <h1 class="titoloreg">Registrazione</h1>

        <!-- One "tab" for each step in the form: -->
        <div class="tab">
          <p><input type="text" placeholder="Nome" name="nome" oninput="this.className = ''"></p>
          <p><input type="text" placeholder="Cognome" name="cognome" oninput="this.className = ''"></p>
        </div>

		<%
			if (request.getAttribute("erroreInserimento") != null) {
		%>
		<div class="alert alert-danger" role="alert">Dati inseriti errati!</div>
		<%
			}
		%>

				<div class="tab">
          <p><input type="date" placeholder="Data di nascita" name="datadinascita" oninput="this.className = ''"></p>
          <p><input type="text" placeholder="Codice Fiscale" name="cf" pattern="^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$"
              oninput="this.className = ''"></p>
              <p><input type="text" placeholder="Indirizzo" name="indirizzo" oninput="this.className = ''"></p>    
        </div>

        <div class="tab">
          <p><input type="text" placeholder="CAP" name="cap" oninput="this.className = ''"></p>
          <p><input type="text" placeholder="Citt&agrave;" name="citta" oninput="this.className = ''"></p>
          <div class="form-group">
            <div class="row">
              <select class="stileselect" id="provincia" name="provincia">
                <option value="" selected class="btn">Provincia</option>
                <option value="AG">Agrigento</option>
                <option value="AL">Alessandria</option>
                <option value="AN">Ancona</option>
                <option value="AO">Aosta</option>
                <option value="AR">Arezzo</option>
                <option value="AP">Ascoli Piceno</option>
                <option value="AT">Asti</option>
                <option value="AV">Avellino</option>
                <option value="BA">Bari</option>
                <option value="BL">Belluno</option>
                <option value="BN">Benevento</option>
                <option value="BG">Bergamo</option>
                <option value="BI">Biella</option>
                <option value="BO">Bologna</option>
                <option value="BZ">Bolzano</option>
                <option value="BS">Brescia</option>
                <option value="BR">Brindisi</option>
                <option value="CA">Cagliari</option>
                <option value="CL">Caltanissetta</option>
                <option value="CB">Campobasso</option>
                <option value="CE">Caserta</option>
                <option value="CT">Catania</option>
                <option value="CZ">Catanzaro</option>
                <option value="CH">Chieti</option>
                <option value="CO">Como</option>
                <option value="CS">Cosenza</option>
                <option value="CR">Cremona</option>
                <option value="KR">Crotone</option>
                <option value="CN">Cuneo</option>
                <option value="EN">Enna</option>
                <option value="FE">Ferrara</option>
                <option value="FI">Firenze</option>
                <option value="FG">Foggia</option>
                <option value="FO">Forl&igrave; - Cesena</option>
                <option value="FR">Frosinone</option>
                <option value="GE">Genova</option>
                <option value="GO">Gorizia</option>
                <option value="GR">Grosseto</option>
                <option value="IM">Imperia</option>
                <option value="IS">Isernia</option>
                <option value="SP">La Spezia</option>
                <option value="AQ">L'Aquila</option>
                <option value="LT">Latina</option>
                <option value="LE">Lecce</option>
                <option value="LC">Lecco</option>
                <option value="LI">Livorno</option>
                <option value="LO">Lodi</option>
                <option value="LU">Lucca</option>
                <option value="MC">Macerata</option>
                <option value="MN">Mantova</option>
                <option value="MS">Massa Carrara</option>
                <option value="MT">Matera</option>
                <option value="ME">Messina</option>
                <option value="MI">Milano</option>
                <option value="MO">Modena</option>
                <option value="NA">Napoli</option>
                <option value="NO">Novara</option>
                <option value="NU">Nuoro</option>
                <option value="OR">Oristano</option>
                <option value="PD">Padova</option>
                <option value="PA">Palermo</option>
                <option value="PR">Parma</option>
                <option value="PV">Pavia</option>
                <option value="PG">Perugia</option>
                <option value="PS">Pesaro</option>
                <option value="PE">Pescara</option>
                <option value="PC">Piacenza</option>
                <option value="PI">Pisa</option>
                <option value="PT">Pistoia</option>
                <option value="PN">Pordenone</option>
                <option value="PZ">Potenza</option>
                <option value="PO">Prato</option>
                <option value="RG">Ragusa</option>
                <option value="RA">Ravenna</option>
                <option value="RC">Reggio Calabria</option>
                <option value="RE">Reggio Emilia</option>
                <option value="RI">Rieti</option>
                <option value="RN">Rimini</option>
                <option value="RM">Roma</option>
                <option value="RO">Rovigo</option>
                <option value="SA">Salerno</option>
                <option value="SS">Sassari</option>
                <option value="SV">Savona</option>
                <option value="SI">Siena</option>
                <option value="SR">Siracusa</option>
                <option value="SO">Sondrio</option>
                <option value="TA">Taranto</option>
                <option value="TE">Teramo</option>
                <option value="TR">Terni</option>
                <option value="TO">Torino</option>
                <option value="TP">Trapani</option>
                <option value="TN">Trento</option>
                <option value="TV">Treviso</option>
                <option value="TS">Trieste</option>
                <option value="UD">Udine</option>
                <option value="VA">Varese</option>
                <option value="VE">Venezia</option>
                <option value="VB">Verbania-Cusio-Ossola</option>
                <option value="VC">Vercelli</option>
                <option value="VR">Verona</option>
                <option value="VV">Vibo Valentia</option>
                <option value="VI">Vicenza</option>
                <option value="VT">Viterbo</option>
              </select>
            </div>
          </div>
        </div>

        <div class="tab">
          <p><input type="email" placeholder="Indirizzo Email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
              oninput="this.className = ''"></p>
          <p><input type="text" placeholder="Username" name="username" oninput="this.className = ''"></p>
          <p><input type="password" name="password" class="form-control d-inline-block pass" placeholder="Password" id="password"
              oninput="this.className = ''"></p>
          <div class="row">
            <div class="col-6">
              <button class="btn btn-outline-secondary d-inline-block" type="button" onclick="mostraPwd()"><i
                  class="fas fa-eye"></i></button>
              <span toggle="#password"></span>
            </div>
            <div class="col-6">
              <div class="form-check form-check-inline d-flex check">
                <input id="checkbox3" type="checkbox" checked="checked" required>
                <label for="checkbox3">Accetto l' <a href="/CinemaNapoli/Home/html/Privacy.jsp"
                    class="term-service">informativa sulla privacy</a></label> 
              </div>
            </div>
          </div>
        </div>


        <div style="overflow:auto;">
          <div style="float:right;">
            <button type="button" class="bottonibelli" id="prevBtn" onclick="nextPrev(-1)">Indietro</button>
            <button type="button" class="bottonibelli" id="nextBtn" onclick="nextPrev(1)">Avanti</button>
          </div>
        </div>

        <!-- Circles which indicates the steps of the form: -->
        <div style="text-align:center;margin-top:40px;">
          <span class="step"></span>
          <span class="step"></span>
          <span class="step"></span>
          <span class="step"></span>
        </div>

      </form>
    </div>
  </div>
  
  <jsp:include page="footer.jsp"></jsp:include>
  
   <script>
    function mostraPwd() {
      var x = document.getElementById("password");
      if (x.type === "password") {
        x.type = "text";
      } else {
        x.type = "password";
      }
    }
  </script>

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
  <script src="/CinemaNapoli/Home/js/registrazione.js"></script>
</body>

</html>