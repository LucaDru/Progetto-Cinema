package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sala;
import static util.GestisciDatabase.*;
import static util.Controlli.*;
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
		
		if(controlloInserimento(request.getParameter("nome")) &&
		   controlloNumeri(request.getParameter("postimax"))) {
			
			s.setId(Long.parseLong(request.getParameter("id")));
			s.setNome(request.getParameter("nome"));
			s.setPostiMax(Integer.parseInt(request.getParameter("postimax")));
			s.setTreD(request.getParameter("treD")==null?false:true);
		
			if(!modificaSala(s))
				request.setAttribute("modificaErrata", "si");
			
		}
		request.setAttribute("controllo", 4);
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
		//doGet(request, response);
	}

}
