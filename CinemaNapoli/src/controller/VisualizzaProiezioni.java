package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;
import static util.GestisciDatabase.*;


@WebServlet(name="visualizzaProiezioni", urlPatterns= {"/VisualizzaProiezioni"})
public class VisualizzaProiezioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public VisualizzaProiezioni() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Proiezione> lista = leggiProiezione();
		request.setAttribute("listaProiezioni", lista);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
