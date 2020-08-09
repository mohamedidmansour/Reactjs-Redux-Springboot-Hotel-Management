package org.emsi.gestionhotel.entity;

import java.io.Serializable;

public class LigneCmdKey implements Serializable {
	private Commande commande;
	private Produit produit;
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public LigneCmdKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCmdKey(Commande commande, Produit produit) {
		super();
		this.commande = commande;
		this.produit = produit;
	}

}
