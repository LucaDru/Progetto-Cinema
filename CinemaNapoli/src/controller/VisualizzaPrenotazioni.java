package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;

@WebServlet(name="visualizzaprenotazioni", urlPatterns = {"/VisualizzaPrenotazioni"})
public class VisualizzaPrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GestisciDatabase gd; 

    public VisualizzaPrenotazioni() {
        super();
        gd = new GestisciDatabase();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Prenotazione> lista = gd.leggiPrenotazione();
		request.setAttribute("listaPrenotazione", lista);
		doGet(request, response);
	}

}
