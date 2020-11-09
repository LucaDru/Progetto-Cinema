package controller;

import static util.GestisciDatabase.*;

import java.io.IOException;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genere;

@WebServlet(name="inserisciGenere", urlPatterns ={"/InserisciGenere"})
public class InserisciGenere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List <Genere> listaGenere;

    public InserisciGenere() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				Genere g=new Genere();
				g.setNome(request.getParameter("nomeGenere"));
				g.setImg(request.getParameter("file").equals("")?null:request.getParameter("file"));
				
				
			
			try {
				aggiungiGenere(g);
			} catch(RollbackException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("VisualizzaListe").forward(request, response);
	}

}
