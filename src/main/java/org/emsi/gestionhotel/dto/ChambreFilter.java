package org.emsi.gestionhotel.dto;

import java.util.Date;

public class ChambreFilter {
	private Date dateDebut;
	private Date dateFin;
	private float prix;
	private long categorie;
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public long getCategorie() {
		return categorie;
	}
	public void setCategorie(long categorie) {
		this.categorie = categorie;
	}
	public ChambreFilter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChambreFilter(Date dateDebut, Date dateFin, float prix, long categorie) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "ChambreFilter [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prix=" + prix + ", categorie="
				+ categorie + "]";
	}
	
	
	
}
