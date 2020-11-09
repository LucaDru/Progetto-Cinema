package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sala;
import static util.GestisciDatabase.*;

@WebServlet(name="modificasala", urlPatterns = {"/ModificaSala"})
public class ModificaSala extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificaSala() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("leggiSala", gd.leggiSala());		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sala s = new Sala();
		
		if(request.getParameter("id") != null) {
			s.setId(Long.parseLong(request.getParameter("id")));
			s.setNome(request.getParameter("nome"));
			s.setPostiMax(Integer.parseInt(request.getParameter("postimax")));
			
			modificaSala(s);
			request.getRequestDispatcher("VisualizzaListe").forward(request, response);
		}
		doGet(request, response);
	}

}
