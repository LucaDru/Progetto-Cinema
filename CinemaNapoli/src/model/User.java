package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="User.findAll",query="SELECT u FROM User u")
public class User implements Serializable {
	//commento di prova
	private static final long serialVersionUID = 1L;
	private long id;
	private String nome,cognome,citta,indirizzo,provincia,cap,cf,piva,email,username,password,avatar;
	private LocalDate datadinascita;
	private boolean admin,staff,attivo,accettato;
	private List<Prenotazione> prenotazioni;
	//---
	public User() {
		super();
	}
	//---
	@Id
	@Column(name="id_user",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	@Column(nullable=false)
	public String getNome() {
		return nome;
	}
	@Column(nullable=false)
	public String getCognome() {
		return cognome;
	}
	@Column(nullable=false)
	public String getCitta() {
		return citta;
	}
	@Column(nullable=false)
	public String getIndirizzo() {
		return indirizzo;
	}
	@Column(nullable=false)
	public String getProvincia() {
		return provincia;
	}
	@Column(nullable=false)
	public String getCap() {
		return cap;
	}
	@Column(unique=true)
	public String getCf() {
		return cf;
	}
	@Column(unique=true)
	public String getPiva() {
		return piva;
	}
	@Column(nullable=false,unique=true)
	public String getEmail() {
		return email;
	}
	@Column(nullable=false,unique=true)
	public String getUsername() {
		return username;
	}
	@Column(nullable=false)
	public String getPassword() {
		return password;
	}
	public String getAvatar() {
		return avatar;
	}
	@Column(nullable=false)
	public LocalDate getDatadinascita() {
		return datadinascita;
	}
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT false")
	public boolean isAdmin() {
		return admin;
	}
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT false")
	public boolean isStaff() {
		return staff;
	}
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	public boolean isAttivo() {
		return attivo;
	}
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT false")
	public boolean isAccettato() {
		return accettato;
	}
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	//---
	//---
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public void setPiva(String piva) {
		this.piva = piva;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public void setDatadinascita(LocalDate datadinascita) {
		this.datadinascita = datadinascita;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public void setStaff(boolean staff) {
		this.staff = staff;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	public void setAccettato(boolean accettato) {
		this.accettato = accettato;
	}
	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
}
