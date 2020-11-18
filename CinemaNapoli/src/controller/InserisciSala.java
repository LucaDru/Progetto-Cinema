package controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sala;

import static util.Controlli.controlloInserimento;
import static util.Controlli.controlloNumeri;
import static util.Controlli.controlloVuoto;
import static util.GestisciDatabase.*;

@WebServlet(name = "inseriscisala", urlPatterns = { "/InserisciSala" })
public class InserisciSala extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InserisciSala() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Sala s = new Sala();

		if (controlloInserimento(request.getParameter("nome")) && controlloNumeri(request.getParameter("postimax"))) {

			s.setNome(request.getParameter("nome"));
			s.setPostiMax(Integer.parseInt(request.getParameter("posti")));
			System.out.println(request.getParameter("treD"));
			s.setTreD(request.getParameter("treD") == null ? false : true);

			if (!aggiungiSala(s))
				request.setAttribute("salaSbagliata", "si");
		}
		request.setAttribute("controllo", 4);
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
	}
}
