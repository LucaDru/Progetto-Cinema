package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Film;

@WebServlet("/InserisciFilm")
public class InserisciFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase db;
	List<Film>listaFilm;
       
    
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
			List<Film>listaFilm=db.leggiFilm();
			for(Film film:listaFilm) {
				if(!film.getTitolo().equalsIgnoreCase(f.getTitolo()) && !film.getAnnouscita().equals(f.getAnnouscita())) {
					db.aggiungiFilm(f);
					
				
				}
			}
		
		
		
		doGet(request, response);
	}

}
