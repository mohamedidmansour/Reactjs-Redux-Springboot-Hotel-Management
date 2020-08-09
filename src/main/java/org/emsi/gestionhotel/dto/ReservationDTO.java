package org.emsi.gestionhotel.dto;

import java.util.Date;

public class ReservationDTO {
	private long idChambre;
	private String checkOutDate;
	private String checkInDate;
	private long idClient;
	public ReservationDTO(long idChambre, String checkOutDate, String checkInDate, long idClient) {
		super();
		this.idChambre = idChambre;
		this.checkOutDate = checkOutDate;
		this.checkInDate = checkInDate;
		this.idClient = idClient;
	}
	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	@Override
	public String toString() {
		return "ReservationDTO [idChambre=" + idChambre + ", checkOutDate=" + checkOutDate + ", checkInDate="
				+ checkInDate + ", idClient=" + idClient + "]";
	}
	
	
}
