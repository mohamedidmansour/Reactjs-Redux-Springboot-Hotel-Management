package org.emsi.gestionhotel.entity;

import java.awt.print.Book;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ComptePaypal {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String username;
	private String email;
	// client
	@ManyToOne(fetch = FetchType.LAZY)
    private Client client;
	// facturation
	@OneToMany(mappedBy = "comptepaypal", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Facturation> facturations;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Facturation> getFacturations() {
		return facturations;
	}
	public void setFacturations(List<Facturation> facturations) {
		this.facturations = facturations;
	}
	public ComptePaypal(long id, String username, String email, Client client, List<Facturation> facturations) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.client = client;
		this.facturations = facturations;
	}
	public ComptePaypal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
