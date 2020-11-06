package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;
import static util.GestisciDatabase.*;


@WebServlet(name="InserimentoProiezione",urlPatterns={"/InserimentoProiezione"})
public class InserimentoProiezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List <Proiezione> proiezioni;

    public InserimentoProiezione() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			if(request.getParameter("idFilm")!=null) {
				Proiezione p=new Proiezione();
				p.setData(LocalDate.parse(request.getParameter("data")));
				p.setOra(LocalTime.parse(request.getParameter("ora")));
				p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
				p.setFilm(cercaFilm(Long.parseLong(request.getParameter("idFilm"))));
				p.setSala(cercaSala(Long.parseLong(request.getParameter("idSala"))));
				proiezioni=leggiProiezione();
				boolean inserimento = true;
				for(Proiezione proiezione:proiezioni) {
					if(proiezione.getData()!=p.getData() || proiezione.getOra()!=p.getOra() || proiezione.getFilm()	!= p.getFilm()) {
						inserimento = false;
						break;
					}							
				}
				if(inserimento = true) {
					aggiungiProiezione(p);
				}
			}
						
		doGet(request, response);
	}

}
