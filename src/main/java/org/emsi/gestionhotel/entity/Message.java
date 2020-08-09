package org.emsi.gestionhotel.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String body;
	@ManyToOne
	private Utilisateur fromUtilisateur;
	@ManyToOne
	private Utilisateur toUtilisateur;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Boolean etat;
	
	@ManyToOne
	private TypeMessage typeMessage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getFromUtilisateur() {
		return fromUtilisateur;
	}

	public void setFromUtilisateur(Utilisateur fromUtilisateur) {
		this.fromUtilisateur = fromUtilisateur;
	}

	public Utilisateur getToUtilisateur() {
		return toUtilisateur;
	}

	public void setToUtilisateur(Utilisateur toUtilisateur) {
		this.toUtilisateur = toUtilisateur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public TypeMessage getTypeMessage() {
		return typeMessage;
	}

	public void setTypeMessage(TypeMessage typeMessage) {
		this.typeMessage = typeMessage;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(long id, String body, Utilisateur fromUtilisateur, Utilisateur toUtilisateur, Date date,
			Boolean etat, TypeMessage typeMessage) {
		super();
		this.id = id;
		this.body = body;
		this.fromUtilisateur = fromUtilisateur;
		this.toUtilisateur = toUtilisateur;
		this.date = date;
		this.etat = etat;
		this.typeMessage = typeMessage;
	}

	
	
	
	
}
