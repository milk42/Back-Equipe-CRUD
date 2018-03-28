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
@Table(name="arme")
public class ArmeModel implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (length=40)
	private String modele;
	@Column (length=40)
	private String type;
	
	@ManyToOne
	@JoinColumn(name="id_affaire")
	@JsonIgnore
	private AffaireModel affaire;
	
	public String getModele() {
		return modele;
	}

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
	
	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
