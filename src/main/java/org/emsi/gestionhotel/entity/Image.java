package org.emsi.gestionhotel.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String url;
	
	// utilisateur
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Utilisateur utilisateur;
	// espace 
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    private Espace espace;
	// produit 
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Produit produit;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Espace getEspace() {
		return espace;
	}
	public void setEspace(Espace espace) {
		this.espace = espace;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Image(long id, String url, Utilisateur utilisateur, Espace espace, Produit produit) {
		super();
		this.id = id;
		this.url = url;
		this.utilisateur = utilisateur;
		this.espace = espace;
		this.produit = produit;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
