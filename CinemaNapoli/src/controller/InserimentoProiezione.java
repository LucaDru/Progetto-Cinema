package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;
import static util.GestisciDatabase.*;


@WebServlet(name="InserimentoProiezione",urlPatterns={"/InserimentoProiezione"})
public class InserimentoProiezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List <Proiezione> proiezioni;

    public InserimentoProiezione() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Proiezione p = new Proiezione();
		p.setData(Date.valueOf(request.getParameter("data")));
		System.out.println(request.getParameter("ora"));
		p.setOra(Time.valueOf(request.getParameter("ora")+":00"));
		p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		p.setFilm(cercaFilm(Long.parseLong(request.getParameter("film"))));
		p.setSala(cercaSala(Long.parseLong(request.getParameter("sala"))));
		
		proiezioni = leggiProiezione();
		boolean inserimento = true;
		
		if(p.getData().toLocalDate().isBefore(LocalDate.now())) {
			inserimento=false;
			request.setAttribute("dataSbagliata", "si");
		}
		else {
			for(Proiezione pr:proiezioni) {
				if(pr.getData().toLocalDate().isEqual(p.getData().toLocalDate())
						&& pr.getOra().toLocalTime().getHour()==p.getOra().toLocalTime().getHour()
						&& pr.getOra().toLocalTime().getMinute()==p.getOra().toLocalTime().getMinute()
						&& pr.getSala().getId()==p.getSala().getId()) {
					inserimento=false;
					break;
				}
			}
		}
		
		if (inserimento) {
			aggiungiProiezione(p);
		}
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
	}

}
