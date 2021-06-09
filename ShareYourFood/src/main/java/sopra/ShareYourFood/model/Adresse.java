package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity

public class Adresse {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "rue", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String rue;
	@Column(name = "complement", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String complement;
	@Column(name = "codePostal", length = 10)
	@JsonView(Views.ViewCommon.class)
	private String codePostal;
	@Column(name = "ville", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String ville;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entite_id")
	private Entite entite;

	@OneToOne(mappedBy = "adresse")
	private Don don;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String complement, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public String getRue() {
		return rue;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Don getDon() {
		return don;
	}

	public void setDon(Don don) {
		this.don = don;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", complement=" + complement + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	

}
