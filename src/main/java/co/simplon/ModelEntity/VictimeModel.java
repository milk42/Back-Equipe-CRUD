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
@Table(name = "victime")
public class VictimeModel implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length=40)
	private String typeAgression;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeAgression() {
		return typeAgression;
	}
	public void setTypeAgression(String typeAgression) {
		this.typeAgression = typeAgression;
	}
	
	

}
