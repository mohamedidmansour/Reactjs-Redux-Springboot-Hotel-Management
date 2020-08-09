package org.emsi.gestionhotel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TypeTache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	
	@OneToMany(mappedBy = "typeTache",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Tache> taches;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public TypeTache(long id, String libelle, List<Tache> taches) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.taches = taches;
	}

	public TypeTache() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
