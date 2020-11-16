package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.Genere;

import static util.GestisciDatabase.*;

@WebServlet("/RicercaGenere")
public class RicercaGenere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RicercaGenere() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Genere> listaGeneri = leggiGenere();
		request.setAttribute("listaGeneri", listaGeneri);
		request.getRequestDispatcher("Home/html/categorie.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}