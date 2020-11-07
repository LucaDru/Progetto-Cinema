package controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import static util.GestisciDatabase.*;

@WebServlet("/RicercaUser")
public class RicercaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List <User> u;
    private List<User> userFiltrati;
    public RicercaUser() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		u = leggiUser();
		
		if(request.getParameter("user") != null) {
			userFiltrati = u.stream().filter( s-> s.getRuolo().getNome().equals(request.getParameter("user"))).collect(Collectors.toList());
		}else if (request.getParameter("staff") != null) {
			userFiltrati = u.stream().filter(s -> s.getRuolo().getNome().equals(request.getParameter("staff"))).collect(Collectors.toList());
		}else if(request.getParameter("daAccettare") != null) {
			userFiltrati = u.stream().filter(s-> s.getRuolo().getNome().equals(request.getParameter("daAccettare"))).collect(Collectors.toList());
		}else if(request.getParameter("bannato") != null) {
			userFiltrati = u.stream().filter(s -> s.getRuolo().getNome().equals("bannato")).collect(Collectors.toList());
		}
		
		request.setAttribute("userFiltrati", userFiltrati);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
