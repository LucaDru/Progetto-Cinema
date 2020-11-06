package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import model.*;


public class GestisciDatabase {

	private static EntityManager getManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaNapoli"); //connetto il database
        EntityManager em  = emf.createEntityManager();
        return em;
	}

    
    //------METODI AGGIUNGI
	public static void aggiungiUser(User u) throws RollbackException {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public static void aggiungiSala(Sala s) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		System.out.println("aggiungo");
		em.persist(s);
		et.commit();
	}
	
	public static void aggiungiFilm(Film f) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(f);
		et.commit();
	}
	
	public static void aggiungiProiezione(Proiezione p) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
	}
	
	public static void aggiungiPrenotazione(Prenotazione p) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
	}
	  
	//----- METODI LEGGI
	public static List<User> leggiUser() {
		EntityManager em=getManager();
		return em.createNamedQuery("User.findAll").getResultList();
		
	}
	
	public static List <Sala> leggiSala() {
		EntityManager em=getManager();
		return em.createNamedQuery("Sala.findAll").getResultList();
	}
	
	public static List <Film> leggiFilm() {
		EntityManager em=getManager();
		return em.createNamedQuery("Film.findAll").getResultList();
	}
	
	public static List <Proiezione> leggiProiezione() {
		EntityManager em=getManager();
		return em.createNamedQuery("Proiezione.findAll").getResultList();
	}
	
	
	public static List <Prenotazione> leggiPrenotazione() {
		EntityManager em=getManager();
		return em.createNamedQuery("Prenotazione.findAll").getResultList();
	}
	
	
	//------METODI MODIFICA
	public static void modificaUser(User u) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(u);
		et.commit(); 
	}
	
	public static void modificaSala(Sala s) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(s);
		et.commit();
	}
	 
	public static void modificaFilm(Film f) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(f);
		et.commit();
	}
	
	public static void modificaProiezione(Proiezione p) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
	}
	
	public static void modificaPrenotazione(Prenotazione p) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(p);
		et.commit();
	}
	
	//-----METODO ELIMINA
	public static void annullaPrenotazione(Prenotazione p) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(p);
		et.commit();
	}
	
	//-----METODI RICERCA SPECIFICA
	public static User cercaUser(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		User u=em.find(User.class, id);
		et.commit();
		return u;
	}
	
	public static User cercaUserByUsername(String username) {
		EntityManager em=getManager();
		return em.createQuery("SELECT u FROM User u WHERE u.username='"+username+"'",User.class).getSingleResult();
	}
	
	public static Film cercaFilm(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Film f=em.find(Film.class, id);
		et.commit();
		return f;
	}
	
	public static Sala cercaSala(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Sala s=em.find(Sala.class, id);
		et.commit();
		return s;
	}
	
	public static Proiezione cercaProiezione(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Proiezione p=em.find(Proiezione.class, id);
		et.commit();
		return p;
	}
	public static List<Proiezione> cercaProiezioneByTitolo(String titolo){
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		List<Proiezione> lista=em.createQuery("SELECT p FROM Proiezione p WHERE titolo LIKE '%"+titolo+"%'").getResultList();
		et.commit();
		return lista;
	}
	
	public static Prenotazione cercaPrenotazione(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Prenotazione p=em.find(Prenotazione.class, id);
		et.commit();
		return p;
	}
	
	public static Ruolo cercaRuolo(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Ruolo r=em.find(Ruolo.class, id);
		et.commit();
		return r;
	}
	
	public static Genere cercaGenere(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Genere g=em.find(Genere.class, id);
		et.commit();
		return g;
	}
}
