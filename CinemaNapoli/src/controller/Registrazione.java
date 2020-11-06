package controller;

import static util.GestisciDatabase.*;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

@WebServlet(name="registrazione", urlPatterns={"/Registrazione"})
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//---
    public Registrazione() {
        super();        
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User u = new User();
		Ruolo r = cercaRuolo(1);
		u.setRuolo(r);
		u.setAttivo(true);
		u.setNome(request.getParameter("nome"));
		u.setCognome(request.getParameter("cognome"));
		u.setDatadinascita(Date.valueOf(request.getParameter("datadinascita")));
		u.setCitta(request.getParameter("citta"));
		u.setProvincia(request.getParameter("provincia"));
		u.setIndirizzo(request.getParameter("indirizzo"));
		u.setCap(request.getParameter("cap"));
		u.setCf(request.getParameter("cf").equals("") ? null : request.getParameter("cf"));
		u.setPiva(request.getParameter("piva").equals("") ? null : request.getParameter("piva"));
		u.setEmail(request.getParameter("email"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));

		String presente = "no";

		try {
			aggiungiUser(u);
		} catch (RollbackException e) {
			e.printStackTrace();
			presente = "si";
		}

		request.setAttribute("giaPresente", presente);
		request.getRequestDispatcher("registrazione.jsp").forward(request, response);
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
