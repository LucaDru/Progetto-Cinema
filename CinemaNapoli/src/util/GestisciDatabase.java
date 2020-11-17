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
	public static boolean aggiungiUser(User u) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(u);
			et.commit();			
		}catch (RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean aggiungiSala(Sala s) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(s);
			et.commit();			
		}catch(RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
	
	public static boolean aggiungiPrenotazione(Prenotazione p) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(p);
			et.commit();			
		}catch(RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean aggiungiGenere(Genere g) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.persist(g);
			et.commit();			
		}catch (RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
		List<Proiezione> lista=em.createNamedQuery("Proiezione.findAll").getResultList();
		lista.forEach(p->p.setPosti());
		return lista;
	}
	
	
	public static List <Prenotazione> leggiPrenotazione() {
		EntityManager em=getManager();
		return em.createNamedQuery("Prenotazione.findAll").getResultList();
	}
	
	
	//------METODI MODIFICA
	public static boolean modificaUser(User u) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(u);
			et.commit(); 			
		}catch(RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean modificaSala(Sala s) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(s);
			et.commit();
		}catch(RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	 
	public static void modificaFilm(Film f) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(f);
		et.commit();
	}
	
	public static boolean modificaGenere(Genere g) {
		try {
			EntityManager em=getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(g);
			et.commit();			
		}catch(RollbackException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
	
	public static User cercaUserByUsername(String username, String pwd) {		
		try {
			EntityManager em = getManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query q = em.createQuery("SELECT u FROM User u WHERE u.username= :users AND u.password= :pwd");
			q.setParameter("users", username);
			q.setParameter("pwd", pwd);
			et.commit();
			return (User) q.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	public static User cercaUserByEmail (String email) {
		try {
			EntityManager em = getManager();
			EntityTransaction et=em.getTransaction();
			et.begin();			
			Query q = em.createQuery("SELECT u FROM User u WHERE u.email= :email");
			q.setParameter("email", email);
			et.commit();
			return (User) q.getSingleResult();
			
		}catch (NoResultException e) {
			e.printStackTrace();
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
		Query q = em.createQuery("SELECT f FROM Film f WHERE f.titolo LIKE :titolo");
		q.setParameter("titolo", titolo);
		List<Film> lista= q.getResultList();
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
		p.setPosti();
		return p;
	}
	
	public static List<Proiezione> cercaProiezioniFuture(){
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("SELECT p FROM Proiezione p WHERE p.data> :dataOdierna OR (p.data =:dataOd AND p.ora>= :oraOdierna)");
		q.setParameter("dataOdierna", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("dataOd", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("oraOdierna", Calendar.getInstance().getTime(),TemporalType.TIME);
		List<Proiezione> lista=q.getResultList();
		lista=lista.parallelStream().sorted((a,b)->a.compareDataOra(b)).collect(Collectors.toList());
		et.commit();
		lista.forEach((p)->p.setPosti());
		return lista;
	}
	
	public static List<Proiezione> cercaProiezioneByTitolo(String titolo){
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("SELECT p FROM Proiezione p WHERE (p.data>= :dataOdierna OR (p.data =:dataOd AND p.ora>= :oraOdierna)) AND p.film.titolo LIKE ':titolo' ");
		q.setParameter("dataOdierna", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("dataOd", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("oraOdierna", Calendar.getInstance().getTime(),TemporalType.TIME);
		q.setParameter("titolo", "%"+titolo+"%");
		List<Proiezione> lista=q.getResultList();
		lista=lista.parallelStream().sorted((a,b)->a.compareDataOra(b)).collect(Collectors.toList());
		et.commit();
		lista.forEach((p)->p.setPosti());
		return lista;
	}
	public static List<Proiezione> cercaProiezioneByIdGenere(long id){
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("SELECT p FROM Proiezione p WHERE (p.data>= :dataOdierna OR (p.data =:dataOd AND p.ora>= :oraOdierna)) AND p.film.genere.id= :id ");
		q.setParameter("dataOdierna", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("dataOd", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("oraOdierna", Calendar.getInstance().getTime(),TemporalType.TIME);
		q.setParameter("id", id);
		List<Proiezione> lista=q.getResultList();
		lista=lista.parallelStream().sorted((a,b)->a.compareDataOra(b)).collect(Collectors.toList());
		et.commit();
		lista.forEach((p)->p.setPosti());
		return lista;
	}
	public static List<Proiezione> cercaProiezioneByIdFilm(long id) {
		EntityManager em=getManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("SELECT p FROM Proiezione p WHERE (p.data>= :dataOdierna OR (p.data =:dataOd AND p.ora>= :oraOdierna)) AND p.film.id= :id ");
		q.setParameter("dataOdierna", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("dataOd", Calendar.getInstance().getTime(),TemporalType.DATE);
		q.setParameter("oraOdierna", Calendar.getInstance().getTime(),TemporalType.TIME);
		q.setParameter("id", id);
		List<Proiezione> lista=q.getResultList();
		lista=lista.parallelStream().sorted((a,b)->a.compareDataOra(b)).collect(Collectors.toList());
		et.commit();
		lista.forEach((p)->p.setPosti());
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
		Query q = em.createQuery("SELECT r FROM Ruolo r WHERE r.nome= :nome");
		q.setParameter("nome", nome);		
		et.commit();
		return (Ruolo) q.getSingleResult();
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
