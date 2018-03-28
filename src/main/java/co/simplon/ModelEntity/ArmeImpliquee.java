package co.simplon.ModelEntity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "armeImpliquee")
@EntityListeners(AuditingEntityListener.class)
public class ArmeImpliquee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_armeImplique;
	@DateTimeFormat
	private Date dateImplication;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_arme", nullable = false)
	@JsonIgnore
	private Arme arme;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_affaire", nullable = false)
	@JsonIgnore
	private Affaire affaire;
	
	public Long getId_armeImplique() {
		return id_armeImplique;
	}
	public void setId_armeImplique(Long id_armeImplique) {
		this.id_armeImplique = id_armeImplique;
	}
	public Date getDateImplication() {
		return dateImplication;
	}
	public void setDateImplication(Date dateImplication) {
		this.dateImplication = dateImplication;
	}
	public Arme getArme() {
		return arme;
	}
	public void setArme(Arme arme) {
		this.arme = arme;
	}
	public Affaire getAffaire() {
		return affaire;
	}
	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}
}
