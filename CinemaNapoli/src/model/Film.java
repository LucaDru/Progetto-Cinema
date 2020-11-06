package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@NamedQuery(name="Film.findAll",query="SELECT f FROM Film f")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String titolo,genere,locandina,trama;
	private int durata, annouscita;
	//---
	public Film() {
		super();
	}
	//---
	@Id
	@Column(name="id_film",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	@Column(nullable=false)
	public String getTitolo() {
		return titolo;
	}
	@Column(nullable=false)
	public String getGenere() {
		return genere;
	}
	@Column(nullable=false)
	public String getLocandina() {
		return locandina;
	}
	@Column(nullable=false)
	public String getTrama() {
		return trama;
	}
	@Column(nullable=false)
	public int getDurata() {
		return durata;
	}
	@Column(nullable=false)
	public int getAnnouscita() {
		return annouscita;
	}
	//---
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}
	public void setTrama(String trama) {
		this.trama = trama;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public void setAnnouscita(int annouscita) {
		this.annouscita = annouscita;
	}
}
