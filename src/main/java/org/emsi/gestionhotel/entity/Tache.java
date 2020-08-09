package org.emsi.gestionhotel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Tache {
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String description;
	@OneToMany(mappedBy = "tache")
	@JsonIgnore
	private List<DateTache> dateTaches;
	
	// Type Tâche
	@ManyToOne(fetch = FetchType.LAZY)
	private TypeTache typeTache;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DateTache> getDateTaches() {
		return dateTaches;
	}

	public void setDateTaches(List<DateTache> dateTaches) {
		this.dateTaches = dateTaches;
	}

	public TypeTache getTypeTache() {
		return typeTache;
	}

	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}

	public Tache(long id, String nom, String description, List<DateTache> dateTaches, TypeTache typeTache) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.dateTaches = dateTaches;
		this.typeTache = typeTache;
	}

	
	
	
	
}
