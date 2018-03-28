package co.simplon.ModelEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "vehicule")
public class VehiculeModel implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (length=40)
	private String type;
	@Column (length=40)
	private String marque;
	@Column (length=40)
	private String modele;
	@Column (length=40)
	private String immatriculation;
	@Column (length=40)
	private String couleur;
	
	@ManyToOne
	@JoinColumn(name="id_affaire")
	@JsonIgnore
	private AffaireModel affaire;
	
	public AffaireModel getAffaire() {
		return affaire;
	}

	public void setAffaire(AffaireModel affaire) {
		this.affaire = affaire;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	
	


}
