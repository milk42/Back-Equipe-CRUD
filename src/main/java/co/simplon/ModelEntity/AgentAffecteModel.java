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
@Table(name="agent")
public class AgentAffecteModel  implements Serializable{
	
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

	
}
