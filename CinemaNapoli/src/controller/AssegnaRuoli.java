package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ruolo;
import model.User;
import util.InvioEmail;

import static util.GestisciDatabase.*;

@WebServlet("/AssegnaRuoli")
public class AssegnaRuoli extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User u;  
    private Ruolo r;
    
    public AssegnaRuoli() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("staff") != null) {
			u = cercaUser(Long.parseLong(request.getParameter("staff")));
			r = cercaRuoloByNome("staff");
			u.setRuolo(r);
			modificaUser(u);
		} else if(request.getParameter("user") != null) {
			u = cercaUser(Long.parseLong(request.getParameter("user")));
			r = cercaRuoloByNome("user");
			u.setRuolo(r);
			modificaUser(u);
			InvioEmail.mandaMail(u, "conferma");
		} else if(request.getParameter("bannato") != null) {
			u = cercaUser(Long.parseLong(request.getParameter("bannato")));
			r = cercaRuoloByNome("bannato");
			u.setRuolo(r);
			modificaUser(u);
		}
		request.getRequestDispatcher("Reindirizzamento").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
