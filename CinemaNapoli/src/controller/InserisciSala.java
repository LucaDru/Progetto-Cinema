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

/**
 * Servlet implementation class InserisciSala
 */
@WebServlet("/InserisciSala")
public class InserisciSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase db;
	List<Sala>sale;   
    
    public InserisciSala() {
        super();
        db=new GestisciDatabase();
       
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sale=db.leggiSala();
		Sala s=new Sala();
		s.setNome(request.getParameter("nome"));
		s.setPostiMax(Integer.parseInt(request.getParameter("posti")));
		for(Sala sala:sale) {
			if((!sala.getNome().equalsIgnoreCase(s.getNome())) && (sala.getPostiMax()!=s.getPostiMax())) {
				db.aggiungiSala(s);
			}//break??
		}
		doGet(request, response);
	}

}