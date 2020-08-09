package org.emsi.gestionhotel.dto;

import java.util.Date;

public class ReservationBureauDTO {
	private long idEspace;
	private String checkOutDate;
	private String checkInDate;
	private long idClient;
	public ReservationBureauDTO(long idEspace, String checkOutDate, String checkInDate, long idClient) {
		super();
		this.idEspace = idEspace;
		this.checkOutDate = checkOutDate;
		this.checkInDate = checkInDate;
		this.idClient = idClient;
	}
	public ReservationBureauDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdEspace() {
		return idEspace;
	}
	public void setIdEspace(long idEspace) {
		this.idEspace = idEspace;
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
		return "ReservationSalleDTO [idEspace=" + idEspace + ", checkOutDate=" + checkOutDate + ", checkInDate="
				+ checkInDate + ", idClient=" + idClient + "]";
	}

	
}
