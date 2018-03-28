package co.simplon.ModelEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "temoin")
public class Temoin implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String temoignage;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_affaire", nullable = false)
	@JsonIgnore
	private Affaire affaire;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personne", nullable = false)
	@JsonIgnore
	private Personne personne;
	
	public Affaire getAffaire() {
		return affaire;
	}	
	public void setAffaire(Affaire affaire) {
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
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
}
