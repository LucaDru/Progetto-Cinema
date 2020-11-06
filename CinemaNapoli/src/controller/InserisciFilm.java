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
import static util.GestisciDatabase.*;

@WebServlet(name="inserisciFilm", urlPatterns={"/InserisciFilm"})
public class InserisciFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Film>listaFilm;
       
    
    public InserisciFilm() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			if(request.getParameter("titolo")!= null) {
				Film f=new Film();
				f.setTitolo(request.getParameter("titolo"));
				f.setGenere(request.getParameter("genere"));
				f.setLocandina(request.getParameter("locandina"));
				f.setTrama(request.getParameter("trama"));
				f.setDurata(Integer.parseInt(request.getParameter("durata")));
				f.setAnnouscita(Integer.parseInt(request.getParameter("annouscita")));
				List<Film>listaFilm=leggiFilm();
				boolean possoinserire = true;
				for(Film film:listaFilm) {
					if(film.getTitolo().equalsIgnoreCase(f.getTitolo()) && film.getAnnouscita()==(f.getAnnouscita())) {
						System.out.println("Il film già c'è");
						possoinserire=false;
						break;				
					}
				}
				if(possoinserire) {
					aggiungiFilm(f);
				}
			}
				
		doGet(request, response);
	}

}

