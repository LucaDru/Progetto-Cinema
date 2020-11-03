package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Sala.findAll",query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome;
	private int postiMax;
	//---
	public Sala() {
		super();
	}
	//---
	@Id
	@Column(name="id_sala",nullable=false)
	public long getId() {
		return id;
	}
	@Column(nullable=false)
	public String getNome() {
		return nome;
	}
	@Column(nullable=false)
	public int getPostiMax() {
		return postiMax;
	}
	//---
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPostiMax(int postiMax) {
		this.postiMax = postiMax;
	}
}
