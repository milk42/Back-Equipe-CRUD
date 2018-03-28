package co.simplon.ModelEntity;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name="agent")
public class AgentAffecte  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length=40)
	private String grade;
	@Column
	private int droitAcces;
	@Column(length=7)
	private String identifiant;
	@Column(length=10)
	private String password;
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
	public String getGrade() {
		return grade;
	}	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getDroitAcces() {
		return droitAcces;
	}
	public void setDroitAcces(int droitAcces) {
		this.droitAcces = droitAcces;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
}
