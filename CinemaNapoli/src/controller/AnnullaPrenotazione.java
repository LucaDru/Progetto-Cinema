package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prenotazione;
import static util.GestisciDatabase.*;
import static util.InvioEmail.*;

@WebServlet(name="annullaPrenotazione", urlPatterns={"/AnnullaPrenotazione"})
public class AnnullaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnnullaPrenotazione() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Prenotazione p = (Prenotazione) session.getAttribute("prenotazione");
		annullaPrenotazione(p);
		//mandaMail(p.getUser(), "annulla");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
