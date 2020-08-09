package org.emsi.gestionhotel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Chambre extends Espace {
    private int nbrLit;
    private int nbrSalledeBain;
    // CATEGORIE CHAMBRE
    @ManyToOne
    private CategorieChambre categorieC;
   
	public int getNbrLit() {
		return nbrLit;
	}
  
	public void setNbrLit(int nbrLit) {
		this.nbrLit = nbrLit;
	}
	public int getNbrSalledeBain() {
		return nbrSalledeBain;
	}
	public void setNbrSalledeBain(int nbrSalledeBain) {
		this.nbrSalledeBain = nbrSalledeBain;
	}

	public CategorieChambre getCategorieC() {
		return categorieC;
	}

	public void setCategorieC(CategorieChambre categorieC) {
		this.categorieC = categorieC;
	}
	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chambre(long id, float prix, String description, List<Image> images, List<Reservation> reservations,
			int nbrLit, int nbrSalledeBain, CategorieChambre categorieC) {
		super(id, prix, description, images, reservations);
		this.nbrLit = nbrLit;
		this.nbrSalledeBain = nbrSalledeBain;
		this.categorieC = categorieC;
	}
	
}
