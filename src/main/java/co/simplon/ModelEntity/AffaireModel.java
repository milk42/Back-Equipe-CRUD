package co.simplon.ModelEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "affaire")
@EntityListeners(AuditingEntityListener.class)
public class AffaireModel implements Serializable{

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


	@OneToMany(cascade= CascadeType.ALL, mappedBy="affaire")
	private Set<VehiculeModel> listVehicule= new HashSet<> ();
	
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="affaire")
	private List<ArmeModel> listArme;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="affaire")
	private List<AgentAffecteModel> listAgentAffecte;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="affaire")
	private List<SuspectModel> listSuspect;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="affaire")
	private List<VictimeModel> listVictime;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy="affaire")
	private List<TemoinModel> listTemoin;
	
	public List<VictimeModel> getListVictime() {
		return listVictime;
	}
	public void setListVictime(List<VictimeModel> listVictime) {
		this.listVictime = listVictime;
	}
	public List<TemoinModel> getListTemoin() {
		return listTemoin;
	}
	public void setListTemoin(List<TemoinModel> listTemoin) {
		this.listTemoin = listTemoin;
	}
	public List<SuspectModel> getListSuspect() {
		return listSuspect;
	}
	public void setListSuspect(List<SuspectModel> listSuspect) {
		this.listSuspect = listSuspect;
	}
	public List<AgentAffecteModel> getListAgentAffecte() {
		return listAgentAffecte;
	}
	public void setListAgentAffecte(List<AgentAffecteModel> listAgentAffecte) {
		this.listAgentAffecte = listAgentAffecte;
	}
	public List<ArmeModel> getListArme() {
		return listArme;
	}
	public void setListArme(List<ArmeModel> listArme) {
		this.listArme = listArme;
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

	public Set<VehiculeModel> getListVehicule() {
		return listVehicule;
	}
	public void setListVehicule(Set<VehiculeModel> listVehicule) {
		this.listVehicule = listVehicule;
	}
	
}
