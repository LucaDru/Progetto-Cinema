package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prenotazione;
import model.User;

import static util.GestisciDatabase.*;
import static util.InvioEmail.*;

@WebServlet(name="annullaPrenotazione", urlPatterns={"/AnnullaPrenotazione"})
public class AnnullaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnnullaPrenotazione() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//mandaMail(p.getUser(), "annulla");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Prenotazione p = cercaPrenotazione(Long.parseLong(request.getParameter("prenotazione")));
		annullaPrenotazione(p);
		request.getSession().setAttribute("userLoggato", cercaUser(((User)request.getSession().getAttribute("userLoggato")).getId()));
		response.sendRedirect("dashUser.jsp");
		
		//doGet(request, response);
	}

}
