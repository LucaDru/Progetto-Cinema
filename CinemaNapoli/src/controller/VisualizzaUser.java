package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;

@WebServlet(name ="visualizzauser", urlPatterns = {"/VisualizzaUser"})
public class VisualizzaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisualizzaUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> lista = leggiUser();
		request.setAttribute("leggiUser", lista);
		request.getRequestDispatcher("dashAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
