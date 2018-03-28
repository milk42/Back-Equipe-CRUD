package co.simplon.ModelEntity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehicule")
public class Vehicule implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_vehicule;
	@NotBlank
	@Size(max = 50)
	private String type;
	@Size(max = 50)
	private String marque;
	@Size(max = 50)
	private String modele;
	@Pattern(regexp="^[A-Z]{1,3}-[0-9]{1,3}-[A-Z]{1,3}$")
	private String immatriculation;
	@Size(max = 50)
	private String couleur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personne")
	@JsonIgnore
	private Personne personne;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="vehiculeImplique")
	private List<VehiculeImplique> listVehiculeImplique;
	
	public Long getId_vehicule() {
		return id_vehicule;
	}	
	public void setId_vehicule(Long id_vehicule) {	
		this.id_vehicule = id_vehicule;
	}
	public String getType() {
		return type;
	}	
	public void setType(String type) {
		this.type = type;
	}	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getCouleur() {
		return couleur;
	}	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}	
	public Personne getPersonne() {
		return personne;
	}	
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}	
	public List<VehiculeImplique> getListVehiculeImplique() {
		return listVehiculeImplique;
	}	
	public void setListVehiculeImplique(List<VehiculeImplique> listVehiculeImplique) {
		this.listVehiculeImplique = listVehiculeImplique;
	}
	
}