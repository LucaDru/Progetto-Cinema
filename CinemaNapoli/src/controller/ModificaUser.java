package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;

@WebServlet(name="modificauser", urlPatterns = {"/ModificaUser"})
public class ModificaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ModificaUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("leggiUser", gd.leggiUser());
		request.getRequestDispatcher("Reindirizzamento").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u= null;
				
			if(request.getParameter("fatturazione") != null) {
				u = (User) request.getSession().getAttribute("userLoggato");
				//u.setId(Long.parseLong(request.getParameter("id")));
				u.setCf(request.getParameter("cf").equals("")? null : request.getParameter("cf"));
				u.setPiva(request.getParameter("piva").equals("")? null : request.getParameter("piva"));				
			} else {
				u= cercaUser(Long.parseLong(request.getParameter("id")));
				u.setNome(request.getParameter("nome"));
				u.setCognome("cognome");
				u.setDatadinascita(Date.valueOf(request.getParameter("datadinascita")));
				u.setCitta(request.getParameter("citta"));
				u.setProvincia(request.getParameter("provincia"));
				u.setIndirizzo(request.getParameter("indirizzo"));
				u.setCap(request.getParameter("cap"));
				u.setCf(request.getParameter("cf"));
				u.setPiva(request.getParameter("piva"));
				u.setEmail(request.getParameter("email"));
				u.setUsername(request.getParameter("username"));
				u.setPassword(request.getParameter("password"));
				
			} 
			modificaUser(u);
		request.getSession().setAttribute("userLoggato", u);
		doGet(request, response);
	}

}
