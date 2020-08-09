package org.emsi.gestionhotel.model;

import org.emsi.gestionhotel.entity.Commande;
import org.emsi.gestionhotel.entity.Produit;
import org.emsi.gestionhotel.repository.CommandeRepository;
import org.emsi.gestionhotel.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LigneCmdDTO {
	
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private ProduitRepository produitRepository;
	private Commande commande;
    private Produit produit;
    private int quantite;
	public CommandeRepository getCommandeRepository() {
		return commandeRepository;
	}
	public void setCommandeRepository(CommandeRepository commandeRepository) {
		this.commandeRepository = commandeRepository;
	}
	public ProduitRepository getProduitRepository() {
		return produitRepository;
	}
	public void setProduitRepository(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
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
