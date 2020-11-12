package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import static util.GestisciDatabase.*;

@WebServlet("/RiepilogoPosti")
public class RiepilogoPosti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//---
    public RiepilogoPosti() {
        super();
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String s="sono arrivati num posti="+request.getParameter("numPosti")+", nello specifico: "
				+request.getParameter("stringaPosti");
		response.getWriter().append(s);
		*/
		Proiezione p=cercaProiezione(Long.parseLong(request.getParameter("idProiezione")));
		//double prezzoTot=p.getPrezzo()*(Integer.parseInt(request.getParameter("numPosti")));
		
		Prenotazione pr=new Prenotazione();
		pr.setProiezione(p);
		pr.setUser((User)request.getSession().getAttribute("userLoggato"));
		pr.setNumPosti(Integer.parseInt(request.getParameter("numPosti")));
		//pr.setBiglietto("Ciao");
		pr.setPosti(request.getParameter("stringaPosti"));
		
		request.setAttribute("prenotazione", pr);
		//request.setAttribute("prezzoTot", prezzoTot);
		
		request.getRequestDispatcher("riepilogone.jsp").forward(request, response);
	}

}
