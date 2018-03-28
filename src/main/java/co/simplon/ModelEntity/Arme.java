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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="arme")
public class Arme implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column (length=40)
	private String modele;
	@Column (length=40)
	private String type;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_affaire")
	@JsonIgnore
	private Affaire affaire;
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL, orphanRemoval = true, mappedBy="arme")
	private List<ArmeImpliquee> listArmeImpliquee;
		
	public String getModele() {
		return modele;
	}
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
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ArmeImpliquee> getListArmeImpliquee() {
		return listArmeImpliquee;
	}
	public void setListArmeImpliquee(List<ArmeImpliquee> listArmeImpliquee) {
		this.listArmeImpliquee = listArmeImpliquee;
	}

}
