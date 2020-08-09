package org.emsi.gestionhotel.entity;

import java.io.Serializable;

public class DateTacheKey implements Serializable {
	private Employe employe;
    private Tache tache;
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public DateTacheKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DateTacheKey(Employe employe, Tache tache) {
		super();
		this.employe = employe;
		this.tache = tache;
	}
    
    
    
}
