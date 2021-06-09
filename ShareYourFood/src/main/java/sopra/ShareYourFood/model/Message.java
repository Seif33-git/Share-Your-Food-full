package sopra.ShareYourFood.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Message")
public class Message {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "contenu")
	@JsonView(Views.ViewCommon.class)
	private String contenu;
	@Column(name = "donneur")
	@JsonView(Views.ViewCommon.class)
	private Boolean donneur;
	@Column(name = "dtEnvoi")
	@JsonView(Views.ViewCommon.class)
	private Date dtEnvoi;
	@ManyToOne
	@JoinColumn(name = "demande_id")
	@JsonView(Views.ViewMessageWithDemande.class)
	private Demande demande;

	public Message() {
		super();
	}

	public Message(String contenu, Boolean donneur) {
		super();
		this.contenu = contenu;
		this.donneur = donneur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Boolean getDonneur() {
		return donneur;
	}

	public void setDonneur(Boolean donneur) {
		this.donneur = donneur;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
