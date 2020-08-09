package org.emsi.gestionhotel.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@javax.persistence.Table(name="tabls")
public class Table {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private int nbPlace;
	
	//reservation
	@ManyToMany
	@JsonIgnore
	private List<Reservation> reservations;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Table(long id, int nbPlace, List<Reservation> reservations) {
		super();
		this.id = id;
		this.nbPlace = nbPlace;
		this.reservations = reservations;
	}

	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
