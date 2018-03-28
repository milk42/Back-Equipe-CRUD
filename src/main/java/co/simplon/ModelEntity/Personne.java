package co.simplon.ModelEntity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length=40)
	private String nom;
	@Column(length=40)
	private String prenom;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="personne")
	private List<AgentAffecte> listAgentAffecte;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="personne")
	private List<Suspect> listSuspect;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="personne")
	private List<Temoin> listTemoin;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="personne")
	private List<Victime> listVictime;
	
	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
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
	public List<AgentAffecte> getListAgentAffecte() {
		return listAgentAffecte;
	}
	public void setListAgentAffecte(List<AgentAffecte> listAgentAffecte) {
		this.listAgentAffecte = listAgentAffecte;
	}
	public List<Suspect> getListSuspect() {
		return listSuspect;
	}
	public void setListSuspect(List<Suspect> listSuspect) {
		this.listSuspect = listSuspect;
	}
	public List<Temoin> getListTemoin() {
		return listTemoin;
	}
	public void setListTemoin(List<Temoin> listTemoin) {
		this.listTemoin = listTemoin;
	}
	public List<Victime> getListVictime() {
		return listVictime;
	}
	public void setListVictime(List<Victime> listVictime) {
		this.listVictime = listVictime;
	}
		
}
