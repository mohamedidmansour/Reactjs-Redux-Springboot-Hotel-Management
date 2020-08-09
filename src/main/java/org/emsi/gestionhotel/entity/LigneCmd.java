package org.emsi.gestionhotel.entity;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@IdClass(LigneCmdKey.class)
public class LigneCmd implements Serializable {
	
	@Id
    @ManyToOne
    @JoinColumn
    private Commande commande;

    @Id
    @ManyToOne
    @JoinColumn
    private Produit produit;

	private int quantite;

	public LigneCmd(Commande commande, Produit produit, int quantite) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}

	public LigneCmd() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, produit, quantite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LigneCmd)) {
			return false;
		}
		LigneCmd other = (LigneCmd) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(produit, other.produit)
				&& quantite == other.quantite;
	}

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

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
