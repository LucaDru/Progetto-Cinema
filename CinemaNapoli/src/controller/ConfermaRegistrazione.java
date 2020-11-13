package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import static util.GestisciDatabase.*;
import static util.InvioEmail.*;

@WebServlet(name="confermareg",urlPatterns={"/ConfermaRegistrazione"})
public class ConfermaRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//---
    public ConfermaRegistrazione() {
        super();
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User u = cercaUser(Long.parseLong(request.getParameter("user")));
		u.setRuolo(cercaRuoloByNome("user"));
		modificaUser(u);
		// --
		mandaMail(u, "conferma", "");
		response.sendRedirect("RicercaUser");
	} 
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}
