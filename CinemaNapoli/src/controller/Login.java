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
		
		//request.getSession().invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		if(request.getParameter("username")!=null) {
			HttpSession session = request.getSession();
			for(User u: db.leggiUser()) {
				if(u.getUsername().equals(request.getParameter("username")) && u.getPassword().equals(request.getParameter("password"))) {
					session.setAttribute("userLoggato", u);
					if(request.getParameter("ricordami")!= null) {
						response.addCookie(new Cookie("userUsername", u.getUsername()));
						response.addCookie(new Cookie("userPassword", u.getPassword()));	
					}
					break;
				}
			}
		}	*/
		
		for(User u: leggiUser()) {
			if(u.getUsername().equals(request.getParameter("username")) && u.getPassword().equals(request.getParameter("password"))) {
				request.getSession().setAttribute("userLoggato", u);
				System.out.println("Loggato bitches!");
				if(request.getParameter("ricordami")!= null) {
					response.addCookie(new Cookie("userUsername", u.getUsername()));
					response.addCookie(new Cookie("userPassword", u.getPassword()));
				}
				break;
			}
		}
		//response.sendRedirect("Login");
		//request.getRequestDispatcher("home.jsp").forward(request, response);
		doGet(request, response);
	}
}



