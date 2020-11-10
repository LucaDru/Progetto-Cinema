package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;
import static util.GestisciDatabase.*;

@WebServlet(name="modificaproiezione", urlPatterns = {"/ModificaProiezione"})
public class ModificaProiezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ModificaProiezione() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("leggiProiezione", gd.leggiProiezione()); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Proiezione p = new Proiezione();
		 
		if(request.getParameter("id") != null) {
			p.setId(Long.parseLong(request.getParameter("id")));
			p.setFilm(cercaFilm(Long.parseLong(request.getParameter("film"))));
			p.setData(Date.valueOf(request.getParameter("data")));
			p.setOra(Time.valueOf(request.getParameter("ora")+":00"));
			p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			p.setSala(cercaSala(Long.parseLong(request.getParameter("sala"))));
			
			modificaProiezione(p);
			request.getRequestDispatcher("VisualizzaListe").forward(request, response);
		}
		doGet(request, response);
	}

}
