package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sala;

@WebServlet(name="modificasala", urlPatterns = {"/ModificaSala"})
public class ModificaSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GestisciDatabase gd;   

    public ModificaSala() {
        super();
        gd = new GestisciDatabase();
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
			
			gd.modificaSala(s);
		}
		doGet(request, response);
	}

}
