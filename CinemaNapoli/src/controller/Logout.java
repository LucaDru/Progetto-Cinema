package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userLoggato");
		Cookie ck = new Cookie ("userUsername", "");
		ck.setMaxAge(0);
		response.addCookie(ck);
		Cookie ck1 = new Cookie ("userPassword", "");
		ck.setMaxAge(0);
		response.addCookie(ck1);
	}

}
