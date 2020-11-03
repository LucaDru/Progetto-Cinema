package controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="login",urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestisciDatabase db;


	public Login() {
		super();
		db=new GestisciDatabase();


	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<User> lista=db.leggiUser();
		session.setAttribute("lista", lista);
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		for(User u:lista) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				session.setAttribute("userloggato", u);
				if(request.getParameter("ricordami")!= null) {
					response.addCookie(new Cookie("userUsername", u.getUsername()));
					response.addCookie(new Cookie("userPassword", u.getPassword()));

				}
				break;
			}
		}

		doGet(request, response);
	}


}



