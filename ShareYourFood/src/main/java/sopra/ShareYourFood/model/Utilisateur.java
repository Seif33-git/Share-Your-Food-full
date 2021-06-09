package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "pseudo")
	private String pseudo;
	@Column(name = "mail")
	private String mail;
	@Column(name = "mot_de_passe")
	private String motDePasse;
	@Column(name = "messagerie_activation")
	private Boolean messagerieActivation;
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entite_id")
	private Entite entite;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String pseudo, String mail, String motDePasse, Boolean messagerieActivation) {
		super();
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.messagerieActivation = messagerieActivation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getMessagerieActivation() {
		return messagerieActivation;
	}

	public void setMessagerieActivation(Boolean messagerieActivation) {
		this.messagerieActivation = messagerieActivation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
