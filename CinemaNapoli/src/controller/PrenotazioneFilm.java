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
		//doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Prenotazione p = new Prenotazione();

		//p.setId(Long.parseLong(request.getParameter("id")));
		p.setProiezione(cercaProiezione(Long.parseLong(request.getParameter("proiezione"))));
		p.setUser((User)request.getSession().getAttribute("userLoggato"));
		p.setNumPosti(Integer.parseInt(request.getParameter("numPosti")));
		p.setPosti(request.getParameter("posti"));
		p.setBiglietto("Ciaone");

		aggiungiPrenotazione(p);
		// mandaMail (p.getUser(), "prenotazione");

		//request.getRequestDispatcher("/CinemaNapoli/paginaRicerca.jsp").forward(request, response);
		response.sendRedirect("RicercaProiezione");
	}

}
