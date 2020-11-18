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
    /*
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);         
        if (session == null || session.getAttribute("username") == null) {
        	response.sendRedirect("Login"); // No logged-in user found, so redirect to login page.
        } else {
        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        	response.setDateHeader("Expires", 0);
            chain.doFilter(req, res);
        }
    }
    */
    //---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	//---
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("userLoggato")!=null && request.getSession()!=null) {
			User u=(User)request.getSession().getAttribute("userLoggato");
			System.out.println(u.getNome());
			if(u.getRuolo().getNome().equals("admin"))
				request.getRequestDispatcher("VisualizzaListe").forward(request, response);
			else if(u.getRuolo().getNome().equals("staff"))
				request.getRequestDispatcher("VisualizzaListe").forward(request, response);
			else
				request.getRequestDispatcher("PrenotazioniUtente").forward(request, response);
		}
		else {
			//request.getRequestDispatcher("Login").forward(request, response);
			//response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        //response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	        //response.setDateHeader("Expires", 0);
	        //---
			response.sendRedirect("Login");
			//doFilter(request, response, chain);
		}
	}
	/*
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	*/
}
