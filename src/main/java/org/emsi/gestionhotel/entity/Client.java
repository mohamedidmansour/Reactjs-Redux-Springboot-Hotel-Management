package org.emsi.gestionhotel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends Utilisateur {
	// compte Paypal
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<ComptePaypal> comptePaypals;
	
	// reservation 
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Reservation> reservations ;

	public List<ComptePaypal> getComptePaypals() {
		return comptePaypals;
	}

	public void setComptePaypals(List<ComptePaypal> comptePaypals) {
		this.comptePaypals = comptePaypals;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Client(long id, String username, String password, List<RoleUtilisateur> roles, String nom, String prenom,
			String cne, String tel, String adresse, Image image, List<ComptePaypal> comptePaypals,
			List<Reservation> reservations) {
		super(id, username, password, roles, nom, prenom, cne, tel, adresse, image);
		this.comptePaypals = comptePaypals;
		this.reservations = reservations;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(long id, String username, String password, List<RoleUtilisateur> roles, String nom, String prenom,
			String cne, String tel, String adresse, Image image) {
		super(id, username, password, roles, nom, prenom, cne, tel, adresse, image);
		// TODO Auto-generated constructor stub
	}
	
	
}
