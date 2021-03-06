package controller;

import static util.GestisciDatabase.*;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

@WebServlet(name = "login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ---
	public Login() {
		super();
	}

	// ---
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Inizializzazione");
	}

	// ---
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * for(User u: leggiUser()) {
		 * if(u.getUsername().equals(request.getParameter("username")) &&
		 * u.getPassword().equals(request.getParameter("password"))) {
		 * 
		 * if(u.isAttivo()) { if(u.getRuolo().getNome().equals("user") ||
		 * u.getRuolo().getNome().equals("admin") ||
		 * u.getRuolo().getNome().equals("staff")) {
		 * 
		 * request.getSession().setAttribute("userLoggato", u);
		 * if(request.getParameter("ricordami")!= null) { response.addCookie(new
		 * Cookie("userUsername", u.getUsername())); response.addCookie(new
		 * Cookie("userPassword", u.getPassword())); }
		 * request.getRequestDispatcher("Home/html/Home.jsp").forward(request,
		 * response);
		 * 
		 * } else { if(u.getRuolo().getNome().equals("bannato"))
		 * request.setAttribute("bannato", "si");
		 * request.getRequestDispatcher("alertDaAccettare.jsp").forward(request,
		 * response); } } else { request.setAttribute("attivo", "no");
		 * request.getRequestDispatcher("alertDaAccettare.jsp").forward(request,
		 * response); } break; } }
		 */
		String encodedPwd = Base64.getEncoder().withoutPadding()
				.encodeToString(request.getParameter("password").getBytes("UTF-8"));
		User u = cercaUserByUsername(request.getParameter("username"), encodedPwd);
		if (u == null) {
			request.setAttribute("sbagliato", "si");
			request.setAttribute("controllo", 1);
			request.getRequestDispatcher("Inizializzazione").forward(request, response);

		} else {

			if (u.isAttivo()) {
				if (u.getRuolo().getNome().equals("user") || u.getRuolo().getNome().equals("admin")
						|| u.getRuolo().getNome().equals("staff")) {

					request.getSession().setAttribute("userLoggato", u);
					if (request.getParameter("ricordami") != null) {
						Cookie c1=new Cookie("userUsername", u.getUsername());
						c1.setMaxAge(60*60*24*30);
						response.addCookie(c1);
						c1=new Cookie("userPassword", u.getPassword());
						c1.setMaxAge(60*60*24*30);
						response.addCookie(c1);
					}
					//request.getRequestDispatcher("Inizializzazione").forward(request, response);
					response.sendRedirect("Inizializzazione");

				} else {
					if (u.getRuolo().getNome().equals("bannato"))
						request.setAttribute("bannato", "si");
					request.getRequestDispatcher("alertDaAccettare.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("attivo", "no");
				request.getRequestDispatcher("alertDaAccettare.jsp").forward(request, response);
			}
		}

	}
}
