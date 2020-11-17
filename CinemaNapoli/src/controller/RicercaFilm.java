package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
		/*
		lista=request.getParameter("genere")!=null?
				cercaGenere(Long.parseLong(request.getParameter("genere"))).getFilms():leggiFilm();
		
		for(Film f : lista) {
			List<Proiezione> filtra = f.getProiezioni();
			for(Proiezione p : filtra) {
				if(p.getData().toLocalDate().isEqual(LocalDate.now()) || p.getData().toLocalDate().isAfter(LocalDate.now())) {
					filmFiltrati.add(f);
					break;
				}
			}
		}*/
		/*for(Film f:filmFiltrati) {
			ciccio.addAll(f.getProiezioni());
			System.out.println(f.getTitolo()+"STO RICERCANDOOOOOO");
		}
		
		Film ciao=filmFiltrati.get(0);
		System.out.println(ciao.getProiezioni());
		
		//List<Proiezione> ciccio=leggiProiezione();
		
		List<Proiezione> ciccio=leggiProiezione().stream()
				.filter(p->p.getData().toLocalDate().isAfter(LocalDate.now()) || 
						(p.getData().toLocalDate().isEqual(LocalDate.now()) && p.getOra().toLocalTime().compareTo(LocalTime.now())==1))
				.sorted((a,b)->a.compareDataOra(b))
				.collect(Collectors.toList());
		//ciccio.sort((a,b)->a.getData().toLocalDate().compareTo(b.getData().toLocalDate()));
		
		ciccio=ciccio.stream().filter(p->p.getData().toLocalDate().isAfter(LocalDate.now()) || 
				(p.getData().toLocalDate().isEqual(LocalDate.now()) && p.getOra().toLocalTime().compareTo(LocalTime.now())==1))
		.sorted((a,b)->a.compareDataOra(b)).peek(p->System.out.println(p)).collect(Collectors.toList());*/
				
		List<Proiezione> ciccio=new ArrayList<Proiezione>();
		List<Film> filmFiltrati = new ArrayList<Film>();
		
		ciccio=request.getParameter("genere")!=null?
				cercaProiezioneByIdGenere(Long.parseLong(request.getParameter("genere"))):
				request.getParameter("titolo")!=null? cercaProiezioneByTitolo(request.getParameter("titolo")):
				request.getParameter("idFilm")!=null? cercaProiezioneByIdFilm(Long.parseLong(request.getParameter("idFilm"))):
				cercaProiezioniFuture();
	
		
		for(Proiezione p:ciccio) {
			System.out.println(p.getData()+"hello");
		}
		filmFiltrati=ciccio.parallelStream().map(p->p.getFilm()).distinct().collect(Collectors.toList());
		
		
		request.setAttribute("proiezOrdinate", ciccio);
		request.setAttribute("filmFiltrati", filmFiltrati);
		request.getRequestDispatcher("Home/html/RicercaAv.jsp").forward(request, response);
		//doGet(request, response);
	}

}
