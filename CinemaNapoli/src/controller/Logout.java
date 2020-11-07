package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	//---
    public Logout() {
        super();
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie ck = new Cookie ("userPassword", "");
		ck.setMaxAge(0);
		response.addCookie(ck);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}
