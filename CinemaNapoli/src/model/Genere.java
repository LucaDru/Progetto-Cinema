package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Genere.findAll",query="SELECT g FROM Genere g")
public class Genere implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome, img;
	private List<Film> films;
	//---
	public Genere() {
		super();
	}
	//---
	@Id
	@Column(name="id_genere",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	@Column(nullable=false,unique=true)
	public String getNome() {
		return nome;
	}
	@Column(nullable=false)
	public String getImg() {
		return img;
	}
	@OneToMany(mappedBy="genere",cascade=CascadeType.ALL)
	public List<Film> getFilms() {
		return films;
	}
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
}
