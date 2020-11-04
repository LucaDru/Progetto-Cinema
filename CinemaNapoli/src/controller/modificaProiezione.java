package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;

@WebServlet(name="modificaproiezione", urlPatterns = {"/modificaProiezione"})
public class modificaProiezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase gd;
	
    public modificaProiezione() {
        super();
        gd = new GestisciDatabase();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("leggiProiezione", gd.leggiProiezione());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Proiezione p = new Proiezione();
		
		if(request.getParameter("id") != null) {
			p.setId(Long.parseLong(request.getParameter("id")));
			p.setFilm(gd.cercaFilm(Long.parseLong(request.getParameter("film"))));
			p.setData(LocalDate.parse(request.getParameter("data")));
			p.setOra(LocalTime.parse(request.getParameter("ora")));
			p.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
			p.setSala(gd.cercaSala(Long.parseLong(request.getParameter("sala"))));
			
			gd.modificaProiezione(p);
		}
		doGet(request, response);
	}

}
