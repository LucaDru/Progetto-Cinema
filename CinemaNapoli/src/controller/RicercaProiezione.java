package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Proiezione;
import static util.GestisciDatabase.*;


@WebServlet(name="ricercaProiezione", urlPatterns= {"/RicercaProiezione"})
public class RicercaProiezione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Proiezione> proiezioni;
	private List<Proiezione> proiezioniFiltrate;



	public RicercaProiezione() {
		super();		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		proiezioniFiltrate=new ArrayList<Proiezione>();
		proiezioni=request.getParameter("titolo")!=null?cercaProiezioneByTitolo(request.getParameter("titolo")):leggiProiezione();
		//
		proiezioni=proiezioni.stream()
				.filter(p->p.getData().toLocalDate().isAfter(LocalDate.now()) || 
						(p.getData().toLocalDate().isEqual(LocalDate.now()) && p.getOra().toLocalTime().compareTo(LocalTime.now())==1))
				.collect(Collectors.toList());

		for(int i=0; i<proiezioni.size(); i++) {
			int postiocc=0;
			for(int j=0; j<proiezioni.get(i).getPrenotazioni().size(); j++) {
				postiocc+=proiezioni.get(i).getPrenotazioni().get(j).getNumPosti();

			}if(postiocc<proiezioni.get(i).getSala().getPostiMax()) {
				proiezioniFiltrate.add(proiezioni.get(i));

			}
		}

		
		/*if(request.getParameter("titolo")!= null) {
			proiezioniFiltrate=cercaProiezioneByTitolo(request.getParameter("titolo"));
			//proiezioniFiltrate=proiezioniFiltrate.stream().filter(p->p.getFilm().getTitolo().equalsIgnoreCase(request.getParameter("titolo"))).collect(Collectors.toList());
		}else if(request.getParameter("genere")!= null) {
			proiezioniFiltrate=proiezioni.stream().filter(p->p.getFilm().getGenere().equalsIgnoreCase(request.getParameter("genere"))).collect(Collectors.toList());
		}else*/ if(request.getParameter("data")!= null) {
			proiezioniFiltrate=proiezioni.stream().filter(p->p.getData().toLocalDate().isEqual(LocalDate.parse(request.getParameter("data")))).collect(Collectors.toList());
		}else if(request.getParameter("orario")!= null) {
			proiezioniFiltrate=proiezioni.stream().filter(p->p.getOra().toLocalTime().isAfter(LocalTime.parse(request.getParameter("orario")))).collect(Collectors.toList());
		}else if(request.getParameter("annouscita")!= null) {
			proiezioniFiltrate=proiezioni.stream().filter(p->p.getFilm().getAnnouscita()==(Integer.parseInt(request.getParameter("annouscita")))).collect(Collectors.toList());
		}
		//request.setAttribute("proiezioniFiltrate", proiezioniFiltrate);
		request.setAttribute("listaProiezioni", proiezioniFiltrate);
		request.getRequestDispatcher("paginaRicerca.jsp").forward(request, response);
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
