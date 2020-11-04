package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;


@WebServlet(name="prenotazionefilm", urlPatterns = {"/PrenotazioneFilm"})
public class PrenotazioneFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GestisciDatabase gd;  

    public PrenotazioneFilm() {
        super();
        gd = new GestisciDatabase();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Prenotazione p = new Prenotazione();
		
		if(request.getParameter("id") != null) {
			p.setId(Long.parseLong(request.getParameter("id")));
			p.setProiezione(gd.cercaProiezione(Long.parseLong(request.getParameter("proiezione"))));
			p.setUser(gd.cercaUser(Long.parseLong(request.getParameter("user"))));
			p.setNumPosti(Integer.parseInt(request.getParameter("numposti")));
			p.setPosti(request.getParameter("posti"));
			p.setBiglietto(request.getParameter("biglietto"));
			
			gd.aggiungiPrenotazione(p);
		}
		doGet(request, response);
	}

}
