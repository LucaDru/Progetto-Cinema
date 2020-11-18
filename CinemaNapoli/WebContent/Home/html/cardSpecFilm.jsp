<%@page import="model.Proiezione"%>
<%@page import="model.Film"%>
<%@page import="java.util.List"%>


<%
	List<Film> lista=(List<Film>)request.getAttribute("filmFiltrati");
	List<Proiezione> proiezioni=(List<Proiezione>)request.getAttribute("proiezOrdinate");
	
	for(Film f:lista){
%>
    <!--SINGOLA CARD DEL FILM-->
	<div class="row mx-0 righette">
        <div class="col-2"></div>
        <div class="col-8">
            <div class="card sfondone p-3">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-4 align-items-center d-flex">
                        <img src="<%=f.getLocandina()%>" alt="..." height="400" width="260" class="locanda">
                    </div>
                    
                    <div class="col-7">
                        <h1 class="mb-3 titolofilme"><%=f.getTitolo()+"("+f.getAnnouscita()+")"%></h1>
                        <p>Genere: <%=f.getGenere().getNome()%></p>
                        <p>Durata: <%=f.getDurata()%>min.</p>
                        <p class="mb-5"><%=f.getTrama()%></p>
                        <form action="/CinemaNapoli/RicercaFilm" method="post" class="formPrenotazione">
                            <div class="input-group input-group-lg px-5">
                                <select class="custom-select" name="proiezione">
                                    <option value="">Scegli la proiezione:</option>
                                    <%                                    	
                                    	int cont=0;
                                    	for(Proiezione p: proiezioni){
                                    		if(p.getFilm().getTitolo().equals(f.getTitolo())){
                                    		if(cont==0){
                                    %>
                                    		<optgroup label="<%=p.getData()%>">                             
                                    		
                                    		<%
                                    		}else if(!(p.getData().toLocalDate().isEqual(proiezioni.get(proiezioni.indexOf(p)-1).getData().toLocalDate()))){
                                    		%>
                                        
                                    		</optgroup>
                                    		<optgroup label="<%=p.getData()%>">
                                    		
                                    		<%} %>
                                    		<option value="<%=p.getId()%>"><%=p.orarioSenzaSecondi()+" (Posti liberi: "%><%= p.getPostiDisp()+")"%>
                                    		</option>                                    
                                    <%
                                    	cont++;}}
                                    %>
                                </select>
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-secondary">
                                        <i class="fas fa-couch"></i>
                                        Prenota
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%
	}
%>