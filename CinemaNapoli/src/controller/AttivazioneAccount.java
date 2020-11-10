package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;
@WebServlet("/AttivazioneAccount")
public class AttivazioneAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AttivazioneAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = null;
		
		if(request.getParameter("attiva") != null) {
			u = cercaUser(Long.parseLong(request.getParameter("attiva")));
			u.setAttivo(true);
			modificaUser(u);
			request.getRequestDispatcher("RicercaUser").forward(request, response);
		
		}else if (request.getParameter("disattiva") != null){
			u = cercaUser(Long.parseLong(request.getParameter("disattiva")));
			u.setAttivo(false);
			modificaUser(u);
			request.getRequestDispatcher("RicercaUser").forward(request, response);
		
		}else if(request.getParameter("elimina") != null) {
			u = (User) request.getSession().getAttribute("userLoggato");
			u.setAttivo(false);
			modificaUser(u);
			request.getRequestDispatcher("Logout").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
