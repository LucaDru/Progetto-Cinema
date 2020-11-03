package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.Prenotazione;
import model.Proiezione;
import model.Sala;
import model.User;


@WebServlet("/GestisciDatabase")
public class GestisciDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private EntityManager em;
	
    public GestisciDatabase() {
        super();
        emf = Persistence.createEntityManagerFactory("CinemaNapoli");
        em = emf.createEntityManager();
    }
    
    //------METODI AGGIUNGI
	public void aggiungiUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	public void aggiungiSala(Sala s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}
	
	public void aggiungiFilm(Film f) {
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
	}
	
	public void aggiungiProiezione(Proiezione p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void aggiungiPrenotazione(Prenotazione p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	//----- METODI LEGGI
	public List<User> leggiUser() {
		return em.createNamedQuery("User.findAll").getResultList();
		
	}
	
	public List <Sala> leggiSala() {
		return em.createNamedQuery("Sala.findAll").getResultList();
	}
	
	public List <Film> leggiFilm() {
		return em.createNamedQuery("Film.findAll").getResultList();
	}
	
	public List <Proiezione> leggiProiezione() {
		return em.createNamedQuery("Proiezione.findAll").getResultList();
	}
	
	public List <Prenotazione> leggiPrenotazione() {
		return em.createNamedQuery("Prenotazione.findAll").getResultList();
	}
	
	//------METODI MODIFICA
	public void modificaUser(User u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit(); 
	}
	
	public void modificaSala(Sala s) {
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
	}
	 
	public void modificaFilm(Film f) {
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
	}
	
	public void modificaProiezione(Proiezione p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void modificaPrenotazione(Prenotazione p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
}
