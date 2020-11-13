package controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;
import static util.Controlli.*;
import static util.InvioEmail.*;

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
			String pwd=resetPassword();
			mandaMail(u,"reset",pwd);
			String encodedPwd=Base64.getEncoder().withoutPadding().encodeToString(pwd.getBytes("UTF-8"));
			u.setPassword(encodedPwd);
			modificaUser(u);
			request.getRequestDispatcher("Reindirizzamento").forward(request, response);
		
		} else {
			User u=cercaUserByUsername(request.getParameter("username"));
			if(u.getEmail().equals(request.getParameter("email"))){
				String pwd=resetPassword();
				mandaMail(u,"reset",pwd);
				String encodedPwd=Base64.getEncoder().withoutPadding().encodeToString(pwd.getBytes("UTF-8"));
				u.setPassword(encodedPwd);
				modificaUser(u);
				response.sendRedirect("Inizializzazione");
			}
		}
		//request.getSession().setAttribute("userLoggato", u);
	}
}
