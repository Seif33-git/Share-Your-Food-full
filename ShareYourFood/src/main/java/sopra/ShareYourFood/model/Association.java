package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Association")
public class Association extends Entite {

	@Column(name = "numeroAssociation", length = 45)
	private String numeroAssociation;

	@Column(name = "justificatif")
	private String justificatif;

	public Association() {
		super();
	}

	public Association(String numeroAssociation, String justificatif) {
		super();
		this.numeroAssociation = numeroAssociation;
		this.justificatif = justificatif;
	}

	public Association(String nom, boolean donneur, boolean beneficiaire, String numeroAssociation,
			String justificatif) {
		super(nom, donneur, beneficiaire);
		this.numeroAssociation = numeroAssociation;
		this.justificatif = justificatif;
	}

	public String getNumeroAssociation() {
		return numeroAssociation;
	}

	public void setNumeroAssociation(String numeroAssociation) {
		this.numeroAssociation = numeroAssociation;
	}

	public String getJustificatif() {
		return justificatif;
	}

	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}

}
