package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet(name="reindirizza",urlPatterns={"/Reindirizzamento"})
public class Reindirizzamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//---
    public Reindirizzamento() {
        super();
    }
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//if(request.getSession().getAttribute("userLoggato")!=null) {
			User u=(User)request.getSession().getAttribute("userLoggato");
			if(u.isAdmin())
				request.getRequestDispatcher("dashAdmin.jsp").forward(request, response);
			else if(u.isStaff())
				request.getRequestDispatcher("dashStaff.jsp").forward(request, response);
			else
				request.getRequestDispatcher("dashUser.jsp").forward(request, response);
		//}
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
