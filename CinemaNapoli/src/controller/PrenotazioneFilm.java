package controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;
import model.User;
import util.UtilitiesQrCode;

import static util.GestisciDatabase.*;
import static util.Controlli.*;
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
		boolean controllo = false;

		p.setProiezione(cercaProiezione(Long.parseLong(request.getParameter("idProiezione"))));
		p.setUser((User) request.getSession().getAttribute("userLoggato"));
		p.setNumPosti(Integer.parseInt(request.getParameter("numPosti")));
		p.setPosti(request.getParameter("stringaPosti"));
		
		do {				
			p.setBiglietto(generaBiglietto());
			
			try {
				aggiungiPrenotazione(p);
				UtilitiesQrCode.generateQRCodeImage(p.getBiglietto(), 300, 300, "D:\\Git-Repo\\Progetto-Cinema\\CinemaNapoli\\WebContent\\caroImg\\biglietti");
			} catch (RollbackException e) {
				e.printStackTrace();
				controllo = true;
			}
		}while(controllo);

		mandaMailBiglietto(p.getUser(),"prenotazione", p);
		request.getRequestDispatcher("Inizializzazione").forward(request, response);
	}

}
