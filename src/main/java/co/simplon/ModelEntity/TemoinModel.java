package co.simplon.ModelEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "temoin")
public class TemoinModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String temoignage;
	
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
	public String getTemoignage() {
		return temoignage;
	}
	public void setTemoignage(String temoignage) {
		this.temoignage = temoignage;
	}
	

	
}
