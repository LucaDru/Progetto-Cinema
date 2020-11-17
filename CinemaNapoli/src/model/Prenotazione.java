package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Prenotazione.findAll",query="SELECT pr FROM Prenotazione pr")
public class Prenotazione implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private User user;
	private Proiezione proiezione;
	private String biglietto,posti;
	private int numPosti;
	//---
	public Prenotazione() {
		super();
	}
	//---
	@Id
	@Column(name="id_prenotazione",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user",nullable=false)
	public User getUser() {
		return user;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_proiezione",nullable=false)
	public Proiezione getProiezione() {
		return proiezione;
	}
	@Column(nullable=false,unique=true)
	public String getBiglietto() {
		return biglietto;
	}
	@Column(nullable=false)
	public String getPosti() {
		return posti;
	}
	@Column(nullable=false)
	public int getNumPosti() {
		return numPosti;
	}
	//---
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}
	public void setBiglietto(String biglietto) {
		this.biglietto = biglietto;
	}
	public void setPosti(String posti) {
		this.posti = posti;
	}
	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}
}
