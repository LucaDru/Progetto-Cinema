package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="registrazione", urlPatterns={"/Registrazione"})
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private EntityManager em;
	
    public Registrazione() {
        super();
        emf = Persistence.createEntityManagerFactory("CinemaNapoli");
        em  = emf.createEntityManager();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("nome")!=null) {
			User u = new User();
			u.setNome(request.getParameter("nome"));
			u.setCognome(request.getParameter("cognome"));
			u.setDataDiNascita(request.getParameter("datadinascita"));
			u.setCitta(request.getParameter("citta"));
			u.setProvincia(request.getParameter("provincia"));
			u.setIndirizzo(request.getParameter("indirizzo"));
			u.setCap(request.getParameter("cap"));
			u.setCf(request.getParameter("cf"));
			u.setPiva(request.getParameter("piva"));
			u.setEmail(request.getParameter("email"));
			u.setUserName(request.getParameter("userName"));
			u.setPassword(request.getParameter("password"));
			
			aggiungiUtente(u);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void aggiungiUtente(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		System.out.println("Utente inserito con successo");
	}

}
