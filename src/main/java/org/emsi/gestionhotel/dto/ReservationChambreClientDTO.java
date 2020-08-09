package org.emsi.gestionhotel.dto;

import org.emsi.gestionhotel.entity.Client;
import org.emsi.gestionhotel.entity.Espace;

public class ReservationChambreClientDTO {
	private Client client;
	private Espace espace;
	public ReservationChambreClientDTO(Client client, Espace espace) {
		super();
		this.client = client;
		this.espace = espace;
	}
	public ReservationChambreClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Espace getEspace() {
		return espace;
	}
	public void setEspace(Espace espace) {
		this.espace = espace;
	}
	
	
}
