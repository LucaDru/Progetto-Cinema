package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Ruolo.findAll",query="SELECT r FROM Ruolo r")
public class Ruolo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private List<User> utenti;
	//---
	public Ruolo() {
		super();
	}
	//---
	@Id
	@Column(name="id_ruolo",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	@Column(nullable=false,unique=true)
	public String getNome() {
		return nome;
	}
	@OneToMany(mappedBy="ruolo",cascade=CascadeType.ALL)
	public List<User> getUtenti() {
		return utenti;
	}
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUtenti(List<User> utenti) {
		this.utenti = utenti;
	}
}
