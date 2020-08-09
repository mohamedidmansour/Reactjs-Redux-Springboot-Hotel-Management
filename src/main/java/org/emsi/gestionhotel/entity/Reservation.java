package org.emsi.gestionhotel.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private Boolean etat;
	
	
	// Tables
	@ManyToMany
	@JsonIgnore
	private List<Table> tables;
	
	// Espace
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Espace espace;
	
	public Reservation(long id, Date dateDebut, Date dateFin, Boolean etat, List<Table> tables, Espace espace,
			Receptionniste receptionniste, Serveur serveur, Client client, Facturation facturation, Commande commande) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
		this.tables = tables;
		this.espace = espace;
		this.receptionniste = receptionniste;
		this.serveur = serveur;
		this.client = client;
		this.facturation = facturation;
		this.commande = commande;
	}



	// receptionniste
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private Receptionniste receptionniste;
	
	// Serveur
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private Serveur serveur;
	
	// Client
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Client client;
	
	// Facturation 
	@OneToOne(mappedBy = "reservation")
	@JsonIgnore
    private Facturation facturation;
	
	
	// Commande
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Commande commande;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Boolean getEtat() {
		return etat;
	}


	public void setEtat(Boolean etat) {
		this.etat = etat;
	}


	public List<Table> getTables() {
		return tables;
	}


	public void setTables(List<Table> tables) {
		this.tables = tables;
	}


	public Espace getEspace() {
		return espace;
	}


	public void setEspace(Espace espace) {
		this.espace = espace;
	}


	public Receptionniste getReceptionniste() {
		return receptionniste;
	}


	public void setReceptionniste(Receptionniste receptionniste) {
		this.receptionniste = receptionniste;
	}


	public Serveur getServeur() {
		return serveur;
	}


	public void setServeur(Serveur serveur) {
		this.serveur = serveur;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Facturation getFacturation() {
		return facturation;
	}


	public void setFacturation(Facturation facturation) {
		this.facturation = facturation;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}



	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
