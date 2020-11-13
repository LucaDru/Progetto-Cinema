package controller;

import static util.GestisciDatabase.*;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;

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
		Ruolo r = cercaRuoloByNome("daAccettare");
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
		//u.setPiva(request.getParameter("piva").equals("") ? null : request.getParameter("piva"));
		u.setPiva(null);
		u.setEmail(request.getParameter("email"));
		u.setUsername(request.getParameter("username"));
		String encodedPwd=Base64.getEncoder().withoutPadding().encodeToString(request.getParameter("password").getBytes("UTF-8"));
		u.setPassword(encodedPwd);

		String presente = "no";

		try {
			aggiungiUser(u);
		} catch (RollbackException e) {
			e.printStackTrace();
			presente = "si";
		}

		request.setAttribute("giaPresente", presente);
		request.getRequestDispatcher("Home/html/Registrazione.jsp").forward(request, response);
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
