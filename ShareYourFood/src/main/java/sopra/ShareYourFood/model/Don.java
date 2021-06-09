package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Don")
public class Don {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "date_de_mise_en_ligne", length = 255)
	private Date dateDeMiseEnLigne;
	@Column(name = "créneau", length = 255)
	private String creneau;
	@Column(name = "commentaire", length = 255)
	private String commentaire;
	@Enumerated(EnumType.STRING)
	@Column(name = "destinataire", length = 255)
	private Destinataire destinataire;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entite_id")
	private Entite entite;

	@OneToMany(mappedBy = "don", cascade = CascadeType.ALL)
	private List<Lot> lot = new ArrayList<Lot>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	public Don() {
		super();
	}

	public Don(Date dateDeMiseEnLigne, String creneau, String commentaire, Destinataire destinataire) {
		super();
		this.dateDeMiseEnLigne = dateDeMiseEnLigne;
		this.creneau = creneau;
		this.commentaire = commentaire;
		this.destinataire = destinataire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDeMiseEnLigne() {
		return dateDeMiseEnLigne;
	}

	public void setDateDeMiseEnLigne(Date dateDeMiseEnLigne) {
		this.dateDeMiseEnLigne = dateDeMiseEnLigne;
	}

	public String getCreneau() {
		return creneau;
	}

	public void setCreneau(String creneau) {
		this.creneau = creneau;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Destinataire getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public List<Lot> getLot() {
		return lot;
	}

	public void setLot(List<Lot> lot) {
		this.lot = lot;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Don [id=" + id + ", dateDeMiseEnLigne=" + dateDeMiseEnLigne + ", creneau=" + creneau + ", commentaire="
				+ commentaire + ", destinataire=" + destinataire + "]";
	}
}
