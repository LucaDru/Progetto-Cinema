package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import model.*;


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
	
	//-----METODO ELIMINA
	public void annullaPrenotazione(Prenotazione p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}
	
	//-----METODI RICERCA SPECIFICA
	public User cercaUser(long id) {
		em.getTransaction().begin();
		User u=em.find(User.class, id);
		em.getTransaction().commit();
		return u;
	}
	
	public User cercaUserByUsername(String username) {
		return em.createQuery("SELECT u FROM User u WHERE u.username='"+username+"'",User.class).getSingleResult();
	}
	
	public Film cercaFilm(long id) {
		em.getTransaction().begin();
		Film f=em.find(Film.class, id);
		em.getTransaction().commit();
		return f;
	}
	
	public Sala cercaSala(long id) {
		em.getTransaction().begin();
		Sala s=em.find(Sala.class, id);
		em.getTransaction().commit();
		return s;
	}
	
	public Proiezione cercaProiezione(long id) {
		em.getTransaction().begin();
		Proiezione p=em.find(Proiezione.class, id);
		em.getTransaction().commit();
		return p;
	}
	
	public Prenotazione cercaPrenotazione(long id) {
		em.getTransaction().begin();
		Prenotazione p=em.find(Prenotazione.class, id);
		em.getTransaction().commit();
		return p;
	}
}
