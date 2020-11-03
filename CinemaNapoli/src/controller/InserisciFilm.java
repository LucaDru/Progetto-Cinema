package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;

/**
 * Servlet implementation class InserisciFilm
 */
@WebServlet("/InserisciFilm")
public class InserisciFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase db;
       
    
    public InserisciFilm() {
        super();
        db=new GestisciDatabase();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		Film f=new Film();
		f.setTitolo(request.getParameter("titolo"));
		f.setGenere(request.getParameter("genere"));
		f.setLocandina(request.getParameter("locandina"));
		f.setTrama(request.getParameter("trama"));
		f.setDurata(Integer.parseInt(request.getParameter("durata")));
		f.setAnnouscita(LocalDate.parse(request.getParameter("annouscita")));
		
		doGet(request, response);
	}

}
