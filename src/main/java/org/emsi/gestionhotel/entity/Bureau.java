package org.emsi.gestionhotel.entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Bureau extends Espace {
    private int nbrTable;
    // getters / setters
	public int getNbrTable() {
		return nbrTable;
	}

	public void setNbrTable(int nbrTable) {
		this.nbrTable = nbrTable;
	}

	public Bureau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bureau(long id, float prix, String description, List<Image> images, List<Reservation> reservations) {
		super(id, prix, description, images, reservations);
		// TODO Auto-generated constructor stub
	}
    
    
}
