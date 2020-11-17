package util;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TemporalType;

import model.*;


public class GestisciDatabase {

	private static EntityManager getManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CinemaNapoli"); //connetto il database
		emf.getCache().evictAll();
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
	
	public static void aggiungiSala(Sala s) throws RollbackException {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
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
	
	public static void aggiungiPrenotazione(Prenotazione p) throws RollbackException {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
	}
	public static void aggiungiGenere(Genere g) throws RollbackException {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(g);
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
	public static List <Genere> leggiGenere() {
		EntityManager em=getManager();
		return em.createNamedQuery("Genere.findAll").getResultList();
	}
	
	public static List <Proiezione> leggiProiezione() {
		EntityManager em=getManager();
		//return em.createNamedQuery("Proiezione.findAll").getResultList();
		List<Proiezione> lista=em.createNamedQuery("Proiezione.findAll").getResultList();
		//lista.forEach(pr->em.refresh(pr));
		lista.forEach(p->p.setPosti());
		return lista;
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
	
	public static void modificaGenere(Genere g) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(g);
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
		p=em.merge(p);
		//em.detach(p);
		em.remove(p);
		et.commit();
	}
	
	public static void eliminaSala(Sala s) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(s);
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
		
	       try{
	    	   return em.createQuery("SELECT u FROM User u WHERE u.username='"+username+"'",User.class).getSingleResult();
	    	   //TODO sistemare query con anche pwd
	       } catch(NoResultException e) {
	           return null;
	       }
	}

	
	public static Film cercaFilm(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Film f=em.find(Film.class, id);
		et.commit();
		return f;
	}
	
	public static List<Film> cercaFilmByNome (String titolo) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		List<Film> lista=em.createQuery("SELECT f FROM Film f WHERE f.titolo LIKE '%"+titolo+"%'").getResultList();
		et.commit();
		return lista;
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
		//em.refresh(p);
		p.setPosti();
		return p;
	}
	
	public static List<Proiezione> cercaProiezioniFuture(){
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("SELECT p FROM Proiezione p WHERE p.data >:dataOdierna AND p.ora >:oraOdierna");
		q.setParameter("dataOdierna", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("oraOdierna", Calendar.getInstance().getTime(),TemporalType.TIME);
		List<Proiezione> lista=q.getResultList();
		lista=lista.parallelStream().sorted((a,b)->a.compareDataOra(b)).collect(Collectors.toList());
		et.commit();
		return lista;
	}
	
	public static List<Proiezione> cercaProiezioneByTitolo(String titolo){
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		List<Proiezione> lista=em.createQuery("SELECT p FROM Proiezione p WHERE p.film.titolo LIKE '%"+titolo+"%'").getResultList();
		et.commit();
		return lista;
	}
	public static List<Proiezione> cercaProiezioneById(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		List<Proiezione> lista=em.createQuery("SELECT p FROM Proiezione p WHERE p.film.id="+id).getResultList();
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
	
	public static Ruolo cercaRuoloByNome(String nome) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Ruolo r=em.createQuery("SELECT r FROM Ruolo r WHERE r.nome='"+nome+"'",Ruolo.class).getSingleResult();
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
