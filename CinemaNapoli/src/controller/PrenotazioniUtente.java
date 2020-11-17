package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prenotazione;
import model.User;


@WebServlet("/PrenotazioniUtente")
public class PrenotazioniUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrenotazioniUtente() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u= (User) request.getSession().getAttribute("userLoggato");
		List <Prenotazione> lista= u.getPrenotazioni();
		
		
		
		List <Prenotazione> listaPassate=new ArrayList<Prenotazione>();

		
		List <Prenotazione> listaAttive=new ArrayList<Prenotazione>();
		for(Prenotazione p:lista) {
			if(p.getProiezione().getData().toLocalDate().isBefore(LocalDate.now()) ||
				(p.getProiezione().getData().toLocalDate().isEqual(LocalDate.now()) &&
					 LocalTime.now().isAfter(p.getProiezione().getOra().toLocalTime().minusMinutes(60)))) {
				listaPassate.add(p);
			}else
				listaAttive.add(p);
		}
		
		request.setAttribute("listaPassate", listaPassate);
		request.setAttribute("listaAttive", listaAttive);
		request.getRequestDispatcher("Dash/html/DashUser.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
