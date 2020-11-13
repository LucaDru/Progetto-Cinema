package controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;
import static util.Controlli.*;

@WebServlet(name="resetpassword", urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResetPassword() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("reset") != null) {	
			User u=cercaUser(Long.parseLong(request.getParameter("reset")));
			 
			String encodedPwd=Base64.getEncoder().withoutPadding().encodeToString(resetPassword().getBytes("UTF-8"));
			u.setPassword(encodedPwd);			 				 			 
				request.getRequestDispatcher("Reindirizzamento").forward(request, response);
		
		} else {
			List<User> user = leggiUser();
			for(User u : user) {
				if(u.getUsername().equals(request.getParameter("username")) && u.getEmail().equals(request.getParameter("email"))){
					String encodedPwd=Base64.getEncoder().withoutPadding().encodeToString(resetPassword().getBytes("UTF-8"));
					u.setPassword(encodedPwd);
					response.sendRedirect("home.jsp");
				}
			
		//request.getSession().setAttribute("userLoggato", u);
			}
		}
	}
}
