package org.emsi.gestionhotel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String username; // username : email
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<RoleUtilisateur> roles = new ArrayList<RoleUtilisateur>();
	private String nom;
	private String prenom;
	private String cne;
	private String tel;
	private String adresse;
	
	// Image
	@OneToOne(mappedBy = "utilisateur")
    private Image image;
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}
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
	public List<RoleUtilisateur> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleUtilisateur> roles) {
		this.roles = roles;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Utilisateur(long id, String username, String password, List<RoleUtilisateur> roles, String nom,
			String prenom, String cne, String tel, String adresse, Image image) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.tel = tel;
		this.adresse = adresse;
		this.image = image;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
