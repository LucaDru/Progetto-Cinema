package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;
import model.User;

import static util.GestisciDatabase.*;
import static util.InvioEmail.*;


@WebServlet(name="prenotazionefilm", urlPatterns = {"/PrenotazioneFilm"})
public class PrenotazioneFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrenotazioneFilm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Prenotazione p = new Prenotazione();
		
		if(request.getParameter("id") != null) {
			p.setId(Long.parseLong(request.getParameter("id")));
			p.setProiezione(cercaProiezione(Long.parseLong(request.getParameter("proiezione"))));
			p.setUser(cercaUser(Long.parseLong(request.getParameter("user"))));
			p.setNumPosti(Integer.parseInt(request.getParameter("numposti")));
			p.setPosti(request.getParameter("posti"));
			p.setBiglietto(request.getParameter("biglietto"));			
			
			aggiungiPrenotazione(p);
			//mandaMail (p.getUser(), "prenotazione");
		}
		doGet(request, response);
	}

}
