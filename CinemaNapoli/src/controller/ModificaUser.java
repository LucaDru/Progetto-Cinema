package controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import static util.Controlli.controlloCap;
import static util.Controlli.controlloCf;
import static util.Controlli.controlloEmail;
import static util.Controlli.controlloInserimento;
import static util.Controlli.controlloVuoto;
import static util.GestisciDatabase.*;

@WebServlet(name="modificauser", urlPatterns = {"/ModificaUser"})
public class ModificaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ModificaUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*if(request.getParameter("proiezione")!=null) {			
			request.setAttribute("proiezione", cercaProiezione(Long.parseLong(request.getParameter("proiezione"))));
			request.getRequestDispatcher("complimentoni.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("Reindirizzamento").forward(request, response);*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u= cercaUser(Long.parseLong(request.getParameter("id")));
				
		if(controlloInserimento(request.getParameter("citta")) &&
		   controlloCap(request.getParameter("cap")) &&
		   controlloCf(request.getParameter("cf")) &&
		   controlloEmail(request.getParameter("email")) &&
		   controlloVuoto(request.getParameter("provincia")) &&
		   controlloVuoto(request.getParameter("piva")) &&
		   controlloVuoto(request.getParameter("indirizzo")) &&
		   controlloVuoto(request.getParameter("username")) &&
		   controlloVuoto(request.getParameter("password"))){					

				//u.setId(Long.parseLong(request.getParameter("id")));
				u.setCitta(request.getParameter("citta"));
				u.setProvincia(request.getParameter("provincia"));
				u.setIndirizzo(request.getParameter("indirizzo"));
				u.setCap(request.getParameter("cap"));
				u.setCf(request.getParameter("cf"));
				u.setPiva(request.getParameter("piva").equals("N/D")?null: request.getParameter("piva"));
				u.setEmail(request.getParameter("email"));
				u.setUsername(request.getParameter("username"));
				if(!u.getPassword().equals(request.getParameter("password"))) {
					String encodedPwd=Base64.getEncoder().withoutPadding().encodeToString(request.getParameter("password").getBytes("UTF-8"));
					u.setPassword(encodedPwd);
				}
				
				modificaUser(u);
				request.getSession().setAttribute("userLoggato", u);			
		}
		
		response.sendRedirect("Reindirizzamento");
		
	}
	
	
}
