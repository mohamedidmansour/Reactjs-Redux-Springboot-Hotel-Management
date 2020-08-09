package org.emsi.gestionhotel.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Receptionniste extends Employe {
	
		// reservation 
		@OneToMany(mappedBy = "receptionniste", cascade = CascadeType.ALL)
		@JsonIgnore
	    private List<Reservation> reservations ;

		public List<Reservation> getReservations() {
			return reservations;
		}

		public void setReservations(List<Reservation> reservations) {
			this.reservations = reservations;
		}

		public Receptionniste(float salaire, Date dateEmbauche, Set<Employe> employes, Employe responsable,
				List<DateTache> dateTaches, List<Reservation> reservations) {
			super(salaire, dateEmbauche, employes, responsable, dateTaches);
			this.reservations = reservations;
		}
		public Receptionniste(){

		}
		
		
		
		
}
