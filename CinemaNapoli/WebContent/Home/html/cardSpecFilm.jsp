<%@page import="model.Film"%>
<%@page import="java.util.List"%>

<%
	List<Film> lista=(List<Film>)request.getAttribute("filmFiltrati");
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
                        <form action="#" method="post">
                            <div class="input-group input-group-lg px-5">
                                <select class="custom-select">
                                    <option value="">Scegli la proiezione:</option>
                                    <optgroup label="giorno 1">
                                        <option value="proiezione1">Proiezione1</option>
                                        <option value="proiezione2">Proiezione2</option>
                                    </optgroup>
                                    <optgroup label="giorno 2">
                                        <option value="proiezione1">Proiezione1</option>
                                        <option value="proiezione2">Proiezione2</option>
                                    </optgroup>
                                    <optgroup label="giorno 3">
                                        <option value="proiezione1">Proiezione1</option>
                                        <option value="proiezione2">Proiezione2</option>
                                    </optgroup>
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