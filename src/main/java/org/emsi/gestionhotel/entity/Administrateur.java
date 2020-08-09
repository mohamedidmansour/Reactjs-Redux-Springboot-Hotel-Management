package org.emsi.gestionhotel.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Employe {

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(float salaire, Date dateEmbauche, Set<Employe> employes, Employe responsable,
			List<DateTache> dateTaches) {
		super(salaire, dateEmbauche, employes, responsable, dateTaches);
		// TODO Auto-generated constructor stub
	}
	
	
}
