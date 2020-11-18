package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import static util.GestisciDatabase.*;

@WebServlet(name ="visualizzaliste", urlPatterns = {"/VisualizzaListe"})
public class VisualizzaListe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisualizzaListe() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//--
		List<Sala> listaSale = leggiSala();
		request.setAttribute("listaSale", listaSale);
		//--
		List<Prenotazione> listaPren = leggiPrenotazione();
		request.setAttribute("listaPrenotazione", listaPren);
		//--
		List<Proiezione> listaPro = leggiProiezione();
		request.setAttribute("listaProiezioni", listaPro);
		//--
		List<Film> listaFilm = leggiFilm();
		request.setAttribute("listaFilm", listaFilm);
		//--
		List<Genere> listaGenere = leggiGenere();
		request.setAttribute("listaGenere", listaGenere);
		//--
		
		if(request.getParameter("modificaProiezione")!=null) {
			request.setAttribute("modificaProiezione", request.getParameter("modificaProiezione"));
			request.setAttribute("controllo", 2);
		}
		else if(request.getParameter("modificaFilm")!=null) {
			request.setAttribute("modificaFilm", request.getParameter("modificaFilm"));
			request.setAttribute("controllo", 3);
		}
		else if(request.getParameter("modificaGenere")!=null) {
			request.setAttribute("modificaGenere", request.getParameter("modificaGenere"));
			request.setAttribute("controllo", 3);
		}
		else if(request.getParameter("modificaSala")!=null) {
			request.setAttribute("modificaSala", request.getParameter("modificaSala"));
			request.setAttribute("controllo", 4);
		}
		
		request.getRequestDispatcher("RicercaUser").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
