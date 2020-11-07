package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.Sala;
import static util.GestisciDatabase.*;


@WebServlet(name="inseriscisala",urlPatterns={"/InserisciSala"})
public class InserisciSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Sala>sale;   

	public InserisciSala() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("nome")!= null){
			sale=leggiSala();
			Sala s=new Sala();
			s.setNome(request.getParameter("nome"));
			s.setPostiMax(Integer.parseInt(request.getParameter("posti")));
			boolean possoinserire=true;
			for(Sala sala:sale) {
				if((sala.getNome().equalsIgnoreCase(s.getNome()))) {
					possoinserire=false;
					break;
				}
			}
			if(possoinserire) {
				aggiungiSala(s);
			}
		}
		
	}
}
