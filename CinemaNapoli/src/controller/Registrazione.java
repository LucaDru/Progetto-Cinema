package controller;

import static util.GestisciDatabase.*;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet(name="registrazione", urlPatterns={"/Registrazione"})
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//---
    public Registrazione() {
        super();        
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if(request.getParameter("nome")!=null) {
			User u = new User();
			u.setNome(request.getParameter("nome"));
			u.setCognome(request.getParameter("cognome"));
			u.setDatadinascita(LocalDate.parse(request.getParameter("datadinascita")));
			u.setCitta(request.getParameter("citta"));
			u.setProvincia(request.getParameter("provincia"));
			u.setIndirizzo(request.getParameter("indirizzo"));
			u.setCap(request.getParameter("cap"));
			u.setCf(request.getParameter("cf").equals("")? null:request.getParameter("cf"));
			u.setPiva(request.getParameter("piva").equals("")? null:request.getParameter("piva"));
			u.setEmail(request.getParameter("email"));
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			
			aggiungiUser(u);
			response.sendRedirect("home.jsp");
		//}
			
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
