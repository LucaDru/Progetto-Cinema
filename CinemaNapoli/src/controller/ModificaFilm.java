package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import static util.GestisciDatabase.*;

@WebServlet(name="modificafilm", urlPatterns = {"/ModificaFilm"})
public class ModificaFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ModificaFilm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("listaFilm", gb.leggiFilm());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Film f = new Film();
		
			if(request.getParameter("id") != null) {
				f.setId(Long.parseLong(request.getParameter("id")));
				f.setTitolo(request.getParameter("titolo"));
				f.setGenere(cercaGenere(Long.parseLong(request.getParameter("genere"))));
				f.setDurata(Integer.parseInt(request.getParameter("durata")));
				f.setAnnouscita(Integer.parseInt(request.getParameter("annouscita")));
				f.setTrama(request.getParameter("trama"));
				f.setLocandina(request.getParameter("locandina"));
			
			} 
			
			try {
				modificaFilm(f);
				request.getRequestDispatcher("VisualizzaListe?dash=film").forward(request, response);
			} catch(RollbackException e) {
				e.printStackTrace();
			}
		
		doGet(request, response);
	}

}
