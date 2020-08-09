package org.emsi.gestionhotel.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.List;

@Entity
public class CategorieChambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    
    @OneToMany(mappedBy = "categorieC")
    @JsonIgnore
    private List<Chambre> chambres;
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
	@JsonIgnore
	public List<Chambre> getChambres() {
		return chambres;
	}
	@JsonIgnore
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	public CategorieChambre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieChambre(long id, String libelle, List<Chambre> chambres) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.chambres = chambres;
	}
    
    
}
