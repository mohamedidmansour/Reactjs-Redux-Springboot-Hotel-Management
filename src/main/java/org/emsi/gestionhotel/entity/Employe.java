package org.emsi.gestionhotel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.MetaValue;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employe extends Utilisateur{
	private float salaire;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEmbauche;
	
	// responsable
	
	@OneToMany(mappedBy = "responsable",
			  cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Employe> employes;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employe responsable;
	
	// tache 
	
	@OneToMany(mappedBy = "employe")
	@JsonIgnore
	private List<DateTache> dateTaches;

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public Employe getResponsable() {
		return responsable;
	}

	public void setResponsable(Employe responsable) {
		this.responsable = responsable;
	}
	@JsonGetter
	public List<DateTache> getDateTaches() {
		return dateTaches;
	}

	public void setDateTaches(List<DateTache> dateTaches) {
		this.dateTaches = dateTaches;
	}

	public Employe(float salaire, Date dateEmbauche, Set<Employe> employes, Employe responsable,
			List<DateTache> dateTaches) {
		super();
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
		this.employes = employes;
		this.responsable = responsable;
		this.dateTaches = dateTaches;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

}
