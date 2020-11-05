package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import util.GestisciDatabase;

@WebServlet(name="confermareg",urlPatterns={"/ConfermaRegistrazione"})
public class ConfermaRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase gd;
	//---
    public ConfermaRegistrazione() {
        super();
        gd=new GestisciDatabase();
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("confermaUser")!=null) {
			User u=gd.cercaUser(Long.parseLong(request.getParameter("confermaUser")));
			u.setAccettato(true);
			gd.modificaUser(u);
			//--invio Mail di avvenuta conferma da parte dell'admin
		}
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}
