package org.emsi.gestionhotel.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private float prix;
	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<LigneCmd> ligneCmds;
	
	// Image
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Image> images ;

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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Set<LigneCmd> getLigneCmds() {
		return ligneCmds;
	}

	public void setLigneCmds(Set<LigneCmd> ligneCmds) {
		this.ligneCmds = ligneCmds;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Produit(long id, String libelle, float prix, Set<LigneCmd> ligneCmds, List<Image> images) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.ligneCmds = ligneCmds;
		this.images = images;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
}
