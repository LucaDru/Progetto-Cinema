package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Proiezione.findAll",query="SELECT p FROM Proiezione p")
public class Proiezione implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private Film film;
	private Sala sala;
	private LocalDate data;
	private LocalTime ora;
	private double prezzo;
	private List<Prenotazione> prenotazioni;
	//---
	public Proiezione() {
		super();
	}
	//---
	@Id
	@Column(name="id_proiezione",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	@ManyToOne
	@JoinColumn(name="id_film",nullable=false)
	public Film getFilm() {
		return film;
	}
	@ManyToOne
	@JoinColumn(name="id_sala",nullable=false)
	public Sala getSala() {
		return sala;
	}
	@Column(nullable=false)
	public LocalDate getData() {
		return data;
	}
	@Column(nullable=false)
	public LocalTime getOra() {
		return ora;
	}
	@Column(nullable=false)
	public double getPrezzo() {
		return prezzo;
	}
	@OneToMany(mappedBy="proiezione",cascade=CascadeType.ALL)
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
}
