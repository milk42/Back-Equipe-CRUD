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
@Table(name = "vehiculeImplique")
@EntityListeners(AuditingEntityListener.class)
public class VehiculeImplique implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_vehiculeImplique;
	@DateTimeFormat
	private Date dateImplication;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vehicule", nullable = false)
	@JsonIgnore
	private Vehicule vehicule;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_affaire", nullable = false)
	@JsonIgnore
	private Affaire affaire;
	
	public Long getId_vehiculeImplique() {
		return id_vehiculeImplique;
	}
	public void setId_vehiculeImplique(Long id_vehiculeImplique) {
		this.id_vehiculeImplique = id_vehiculeImplique;
	}
	public Date getDateImplication() {
		return dateImplication;
	}
	public void setDateImplication(Date dateImplication) {
		this.dateImplication = dateImplication;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public Affaire getAffaire() {
		return affaire;
	}
	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

}
