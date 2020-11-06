package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;
/**
 * Servlet implementation class ControlloFatturazione
 */
@WebServlet("/ControlloFatturazione")
public class ControlloFatturazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlloFatturazione() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("userLoggato");	
		System.out.println(u);
		if(u.getCf() == null && u.getPiva() == null) {
			request.getRequestDispatcher("formDatiFatturazione.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("complimentoni.jsp").forward(request, response);
		}

	}

}
