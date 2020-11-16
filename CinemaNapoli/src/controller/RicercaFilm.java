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
		
		Film ciao=filmFiltrati.get(0);
		System.out.println(ciao.getProiezioni());
		//List<Proiezione> ciccio=ciao.getProiezioni();
		/*ciccio.sort((o1,o2)->{if(o1.getData().toLocalDate().isBefore(o2.getData().toLocalDate())) return -1;
							else if(o1.getData().toLocalDate().isAfter(o2.getData().toLocalDate())) return 1;		
							else return 0;});*/
		//Collections.sort(ciccio, new ProvaSort());
		//ciccio=ciccio.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
		//ciao.setProiezioni(ciccio);
		//ciao.getProiezioni().forEach(p->System.out.println(p.getData()+"hello"));
		
		//List<Proiezione> ciccio=cercaProiezioneById(ciao.getId());
		List<Proiezione> ciccio=leggiProiezione();
		ciccio.sort((a,b)->a.getData().toLocalDate().compareTo(b.getData().toLocalDate()));
		
		for(Proiezione p:ciccio) {
			System.out.println(p.getData()+"hello");
		}
		
		
		request.setAttribute("proiezOrdinate", ciccio);
		request.setAttribute("filmFiltrati", filmFiltrati);
		request.getRequestDispatcher("Home/html/RicercaAv.jsp").forward(request, response);
		//doGet(request, response);
	}

}
