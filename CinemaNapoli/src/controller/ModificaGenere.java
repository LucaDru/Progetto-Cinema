package controller;

import static util.GestisciDatabase.aggiungiGenere;
import static util.GestisciDatabase.modificaGenere;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genere;


@WebServlet(name="modificagenere", urlPatterns={"/ModificaGenere"})
public class ModificaGenere extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ModificaGenere() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Genere g = new Genere();
		
		if(request.getParameter("id") != null) {
			g.setId(Long.parseLong(request.getParameter("id")));
			g.setNome(request.getParameter("nome"));
			g.setImg(request.getParameter("file"));
			

			
		}
		
		try {
			modificaGenere(g);
		} catch(RollbackException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
	}

	
	}


