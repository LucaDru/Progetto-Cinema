package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import util.GestisciDatabase;

@WebServlet(name="modificauser", urlPatterns = {"/ModificaUser"})
public class ModificaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase gd;
	
    public ModificaUser() {
        super();
        gd = new GestisciDatabase();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("leggiUser", gd.leggiUser());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		
			if(request.getParameter("id") != null) {
				u.setId(Long.parseLong(request.getParameter("id")));
				u.setCitta(request.getParameter("citta"));
				u.setProvincia(request.getParameter("provincia"));
				u.setIndirizzo(request.getParameter("indirizzo"));
				u.setCap(request.getParameter("cap"));
				u.setCf(request.getParameter("cf"));
				u.setPiva(request.getParameter("piva"));
				u.setEmail(request.getParameter("email"));
				u.setUsername(request.getParameter("username"));
				u.setPassword(request.getParameter("password"));
				
				gd.modificaUser(u);
			}
		doGet(request, response);
	}

}
