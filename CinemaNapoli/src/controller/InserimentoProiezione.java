package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;
import static util.GestisciDatabase.*;
import static util.Controlli.*;

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
			
			boolean inserimento = true;
			
			String stessoOrario="� gi� presente una proiezione a quest'orario.";
			String orarioPre="questa proiezione andrebbe ad accavallarsi con quella precedente.";
			String orarioPost="questa proiezione andrebbe ad accavallarsi con quella successiva.";
			
			if(p.getData().toLocalDate().isBefore(LocalDate.now())) {
				inserimento=false;
				request.setAttribute("dataSbagliata", "si");
			}
			else {
				proiezioni=leggiProiezione().stream()
						.filter(pr->pr.getData().toLocalDate().isEqual(p.getData().toLocalDate()))
						.filter(pro->pro.getSala().getId()==p.getSala().getId())
						.sorted((p1,p2)->p1.compareTo(p2))
						.collect(Collectors.toList());
				//
				Proiezione antecedente=null;
				Proiezione successiva=null;
				Proiezione uguale=null;
				//
				for(Proiezione pr:proiezioni) {
					if(pr.compareTo(p)==-1)
						antecedente=pr;
					else if(pr.compareTo(p)==0)
						uguale=pr;
					else if(pr.compareTo(p)==1) {
						successiva=pr;
						break;
					}
				}
				if(uguale!=null) {
					inserimento=false;
					request.setAttribute("orarioSbagliato", stessoOrario);
				}
				//
				else if(antecedente!=null && 
						antecedente.getOra().toLocalTime().plusMinutes(antecedente.getFilm().getDurata()+15)
						.compareTo(p.getOra().toLocalTime())==1) {
					inserimento=false;
					request.setAttribute("orarioSbagliato", orarioPre);
				}
				//
				else if(successiva!=null && 
						p.getOra().toLocalTime().plusMinutes(p.getFilm().getDurata()+15)
						.compareTo(successiva.getOra().toLocalTime())==1) {
					inserimento=false;
					request.setAttribute("orarioSbagliato", orarioPost);
				}
			}
			//---		
			if (inserimento) {
				aggiungiProiezione(p);
			}

		request.setAttribute("controllo", 2);
		request.getRequestDispatcher("VisualizzaListe").forward(request, response);
	}
}
