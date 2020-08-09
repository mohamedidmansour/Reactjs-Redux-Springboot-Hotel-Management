package org.emsi.gestionhotel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@IdClass(DateTacheKey.class)
public class DateTache implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn
	private Tache tache;
	@Id
	@ManyToOne
	@JoinColumn
	private Employe employe;	
	private String dureeTache;
	private Boolean etat;
	
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public String getDureeTache() {
		return dureeTache;
	}
	public void setDureeTache(String dureeTache) {
		this.dureeTache = dureeTache;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	
	public DateTache(Tache tache, Employe employe, String dureeTache, Boolean etat) {
		super();
		this.tache = tache;
		this.employe = employe;
		this.dureeTache = dureeTache;
		this.etat = etat;
	}
	public DateTache() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
