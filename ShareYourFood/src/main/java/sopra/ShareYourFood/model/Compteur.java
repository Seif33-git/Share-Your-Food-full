package sopra.ShareYourFood.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="demande")
public class Compteur {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name="visiteurs")
	@JsonView(Views.ViewCommon.class)
	private Long visiteur;
	
	
	
	public Compteur() {
		super();		
	}
	
	public Compteur(Long visiteur) {
		super();
		this.visiteur = visiteur;
	}
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Long getVisiteur() {
		return visiteur;
	}
	public void setVisiteur(Long visiteur) {
		this.visiteur = visiteur;
	}
	
	
}
