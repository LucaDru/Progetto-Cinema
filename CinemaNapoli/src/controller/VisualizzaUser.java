package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebServlet(name ="visualizzauser", urlPatterns = {"/VisualizzaUser"})
public class VisualizzaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GestisciDatabase gd;   

    public VisualizzaUser() {
        super();
        gd = new GestisciDatabase();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> lista = gd.leggiUser();
		request.setAttribute("leggiUser", lista);
		doGet(request, response);
	}

}
