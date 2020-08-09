package org.emsi.gestionhotel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Espace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private long id;
    @Column(nullable = true)
    private float prix;
    @Column(nullable = true)
    private String description;
    
    // Image
    @OneToMany(mappedBy = "espace", cascade = CascadeType.ALL)
    private List<Image> images;
    
    // reservation
    @OneToMany(mappedBy = "espace", cascade = CascadeType.ALL)
    //@JsonIgnore
    private List<Reservation> reservations;

    
   

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Espace(long id, float prix, String description, List<Image> images, List<Reservation> reservations) {
		super();
		this.id = id;
		this.prix = prix;
		this.description = description;
		this.images = images;
		this.reservations = reservations;
	}

	public Espace() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
