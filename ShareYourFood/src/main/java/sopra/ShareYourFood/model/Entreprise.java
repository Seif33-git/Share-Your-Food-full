package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Entreprise")
@NamedQuery(name = "Entreprise.findAllEntreprise", query = "select e from Entreprise e")
public class Entreprise extends Entite {

	@Column(name = "prenom", length = 45)
	@JsonView(Views.ViewEntreprise.class)
	private String siret;

	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", length = 45)
	@JsonView(Views.ViewEntreprise.class)
	private Categorie categorie;

	public Entreprise() {
		super();
	}

	public Entreprise(String siret, Categorie categorie) {
		super();
		this.siret = siret;
		this.categorie = categorie;
	}

	public Entreprise(String nom, boolean donneur, boolean beneficiaire, String siret, Categorie categorie) {
		super(nom, donneur, beneficiaire);
		this.siret = siret;
		this.categorie = categorie;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
