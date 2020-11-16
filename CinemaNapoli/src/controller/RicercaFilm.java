package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.Proiezione;

import static util.GestisciDatabase.*;

@WebServlet(name="ricercafilm",urlPatterns={"/RicercaFilm"})
public class RicercaFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Film> lista;
	//private List<Film> filmFiltrati;
	//---
    public RicercaFilm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		lista=leggiFilm();
		
		List<Film> filmFiltrati = new ArrayList<Film>();
		for(Film f : lista) {
			List<Proiezione> filtra = f.getProiezioni();
			for(Proiezione p : filtra) {
				if(p.getData().toLocalDate().isEqual(LocalDate.now()) || p.getData().toLocalDate().isAfter(LocalDate.now())) {
					filmFiltrati.add(f);
					break;
				}
			}
		}
		//filmFiltrati.forEach(f->System.out.println(f.getTitolo()+"STO RICERCANDOOOOOO"));
		for(Film f:filmFiltrati) {
			System.out.println(f.getTitolo()+"STO RICERCANDOOOOOO");
		}
		request.setAttribute("filmFiltrati", filmFiltrati);
		request.getRequestDispatcher("Home/html/RicercaAv.jsp").forward(request, response);
		//doGet(request, response);
	}

}
