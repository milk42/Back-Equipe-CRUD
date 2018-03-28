package co.simplon.ModelEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "affaire")
@EntityListeners(AuditingEntityListener.class)
public class Affaire implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length=40)
	private String nom;
	@DateTimeFormat
	private Date date_creation;
	@DateTimeFormat
	private Date date_cloture;
	@Column(length=40)
	private String lieu;
	@Column(length=40)
	private String rapport;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="affaire")
	private List<VehiculeImplique> listVehiculeImplique;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="affaire")
	private List<ArmeImpliquee> listArmeImpliquee;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="affaire")
	private List<AgentAffecte> listAgentAffecte;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="affaire")
	private List<Suspect> listSuspect;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="affaire")
	private List<Victime> listVictime;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="affaire")
	private List<Temoin> listTemoin;
	
	public List<Victime> getListVictime() {
		return listVictime;
	}
	public void setListVictime(List<Victime> listVictime) {
		this.listVictime = listVictime;
	}	
	public List<Temoin> getListTemoin() {
		return listTemoin;
	}
	public void setListTemoin(List<Temoin> listTemoin) {
		this.listTemoin = listTemoin;
	}	
	public List<Suspect> getListSuspect() {
		return listSuspect;
	}	
	public void setListSuspect(List<Suspect> listSuspect) {
		this.listSuspect = listSuspect;
	}	
	public List<AgentAffecte> getListAgentAffecte() {
		return listAgentAffecte;
	}
	public void setListAgentAffecte(List<AgentAffecte> listAgentAffecte) {
		this.listAgentAffecte = listAgentAffecte;
	}
	public List<ArmeImpliquee> getListArmeImpliquee() {
		return listArmeImpliquee;
	}
	public void setListArmeImpliquee(List<ArmeImpliquee> listArmeImpliquee) {
		this.listArmeImpliquee = listArmeImpliquee;
	}
	public String getNom() {
		return nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_cloture() {
		return date_cloture;
	}
	public void setDate_cloture(Date date_cloture) {
		this.date_cloture = date_cloture;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	public List<VehiculeImplique> getListVehiculeImplique() {
		return listVehiculeImplique;
	}
	public void setListVehiculeImplique(List<VehiculeImplique> listVehiculeImplique) {
		this.listVehiculeImplique = listVehiculeImplique;
	}

}
