package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import static util.GestisciDatabase.*;

@WebServlet(name="inizializzazione",urlPatterns={"/Inizializzazione"})
public class Inizializzazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private List<Film> lista;

    public Inizializzazione() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 		String username=null,pwd=null;
		
		if(request.getSession().getAttribute("userLoggato")==null && request.getCookies()!=null) {
			for(Cookie c:request.getCookies()) {
				System.out.println(c.getName()+" "+c.getValue());
				if(c.getName().equals("userUsername")) username=c.getValue();
				else if(c.getName().equals("userPassword")) pwd=c.getValue();
			}
		}
		if(username!=null && pwd!=null) {
			User u=cercaUserByUsername(username, pwd);
			if(u!=null)
				request.getSession().setAttribute("userLoggato",u);
		}
		
		List<Film> lista=leggiFilm();
		lista.forEach(f->System.out.println(f.getTitolo()+"----aaaaaa----"));
		/*
		for(Film f:lista) {
			List<Proiezione> filtrata=f.getProiezioni().stream().filter(p->
								p.getData().before(Date.valueOf(LocalDate.now())) ||
								p.getData().after(Date.valueOf(LocalDate.now().plusDays(30)))
								).collect(Collectors.toList());
			
			if(f.getProiezioni().size()==filtrata.size()) {
				lista.remove(f);
			}
		}
		*/
		List<Film> listaFilm=new ArrayList<Film>();
		for(Film f:lista) {
			System.out.println("MERDA "+f.getProiezioni().size());
			List<Proiezione> mortacci=f.getProiezioni();
			//mortacci.forEach(peppe->System.out.println(peppe.getId()));
			for(Proiezione p:mortacci) {
				System.out.println(p.getId()+" ECCOLOOO");
				if((p.getData().toLocalDate().isEqual(LocalDate.now()) || p.getData().toLocalDate().isAfter(LocalDate.now()))
						&& p.getData().toLocalDate().isBefore(LocalDate.now().plusDays(30))) {
					listaFilm.add(f);
					break;
				}
			}
		}
		
		request.setAttribute("listaFilm", listaFilm);
		//listaFilm.forEach(f->System.out.println(f.getTitolo()));
		for(Film fi:listaFilm) {
			System.out.println(fi.getTitolo()+" MORTACCI DE PIPPOOOOO");
		}
		request.getRequestDispatcher("Home/html/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
