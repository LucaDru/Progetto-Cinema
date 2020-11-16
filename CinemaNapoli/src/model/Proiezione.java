package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Comparator;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Proiezione.findAll",query="SELECT p FROM Proiezione p")
public class Proiezione implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private Film film;
	private Sala sala;
	private Date data;
	private Time ora;
	private double prezzo;
	private List<Prenotazione> prenotazioni;
	private boolean[] posti;
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
	public Date getData() {
		return data;
	}
	@Column(nullable=false)
	public Time getOra() {
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
	public void setData(Date data) {
		this.data = data;
	}
	public void setOra(Time ora) {
		this.ora = ora;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	//---
	//@Override
	public int compareTo(Proiezione p) {
		System.out.println("Stiamo comparando");
		//int cosa=this.data.toLocalDate().compareTo(p.getData().toLocalDate());
		//System.out.println(cosa+" Questa è la cosa");
		//if(cosa==0) {
			if(ora.toLocalTime().getHour()<p.getOra().toLocalTime().getHour())
				return -1;
			else if(ora.toLocalTime().getHour()==p.getOra().toLocalTime().getHour()) {
				
				if(ora.toLocalTime().getMinute()<p.getOra().toLocalTime().getMinute())
					return -1;
				else if(ora.toLocalTime().getMinute()==p.getOra().toLocalTime().getMinute())
					return 0;
				else
					return 1;
			}
			else
				return 1;
		//}
		//else
			//return cosa;
	}
	//---
	public String orarioSenzaSecondi() {
		String o="";
		char[] orario=(""+ora).toCharArray();
		for(int i=0;i<orario.length;i++) {
			if(i<5) {
				o+=orario[i];
			}
		}
		return o;
	}
	//---
	public void setPosti() {
		posti=new boolean[sala.getPostiMax()];
		if(prenotazioni!=null && prenotazioni.size()>0)
			impostaOccupati();
	}
	public boolean[] getPosti() {
		return posti;
	}
	//---
	private void impostaOccupati() {
		
		String cose="";
		for(Prenotazione pr:prenotazioni) {
			cose+=pr.getPosti();
		}		
		String[] numeri=cose.split("-");
		//
		for(String s:numeri) {
			int numero=Integer.parseInt(s);
			posti[numero]=true;
		}
	}
	/*
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
}
