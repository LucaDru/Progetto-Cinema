package controller;

import static util.GestisciDatabase.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

@WebServlet(name="login",urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//---
	public Login() {
		super();
	}
	//---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		for(User u: leggiUser()) {
			if(u.getUsername().equals(request.getParameter("username")) && u.getPassword().equals(request.getParameter("password"))) {
				/*
				if(u.getRuolo().getNome().equals("daAccettare")) {
					//System.out.println("sono da accettare ancora");
					request.getRequestDispatcher("alertDaAccettare.jsp").forward(request, response);
				}
				else if(u.getRuolo().getNome().equals("bannato")) {
					request.setAttribute("bannato", "si");
					request.getRequestDispatcher("alertDaAccettare.jsp").forward(request, response);
				}
				else {
					request.getSession().setAttribute("userLoggato", u);
					System.out.println("Loggato bitches!");
					if(request.getParameter("ricordami")!= null) {
						response.addCookie(new Cookie("userUsername", u.getUsername()));
						response.addCookie(new Cookie("userPassword", u.getPassword()));
					}
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				*/
				if(u.isAttivo()) {
					if(u.getRuolo().getNome().equals("user") 
							|| u.getRuolo().getNome().equals("admin") 
							|| u.getRuolo().getNome().equals("staff")) {
						
						request.getSession().setAttribute("userLoggato", u);
						if(request.getParameter("ricordami")!= null) {
							response.addCookie(new Cookie("userUsername", u.getUsername()));
							response.addCookie(new Cookie("userPassword", u.getPassword()));
						}
						request.getRequestDispatcher("home.jsp").forward(request, response);
						
					} else {
						if(u.getRuolo().getNome().equals("bannato"))
							request.setAttribute("bannato", "si");
						request.getRequestDispatcher("alertDaAccettare.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("attivo", "no");
					request.getRequestDispatcher("alertDaAccettare.jsp").forward(request, response);
				}
			break;
			}
		}
		//doGet(request, response);
	}
}



