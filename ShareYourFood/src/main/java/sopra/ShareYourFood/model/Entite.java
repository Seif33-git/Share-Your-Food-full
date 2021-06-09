package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "entite")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Entite {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nom", length = 255)
	private String nom;
	@Column(name = "donneur", length = 255)
	private boolean donneur;
	@Column(name = "beneficiaire", length = 255)
	private boolean beneficiaire;
	
	@OneToMany(mappedBy = "entite", cascade = CascadeType.ALL)
	private List<Don> dons = new ArrayList<Don>();
	
	@OneToMany(mappedBy = "entite", cascade = CascadeType.ALL)
	private List<Adresse> adresses = new ArrayList<Adresse>();
	
	@OneToMany(mappedBy = "entite", cascade = CascadeType.ALL)
	private List<Demande> demandes = new ArrayList<Demande>();
	
	@OneToMany(mappedBy = "entite", cascade = CascadeType.ALL)
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	
	public Entite() {
		super();
	}
	public Entite(String nom, boolean donneur, boolean beneficiaire) {
		super();
		this.nom = nom;
		this.donneur = donneur;
		this.beneficiaire = beneficiaire;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Don> getDons() {
		return dons;
	}

//	public void setDons(List<Don> dons) {
//		this.dons = dons;
//	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

//	public void setAdresses(List<Adresse> adresses) {
//		this.adresses = adresses;
//	}

	public List<Demande> getDemandes() {
		return demandes;
	}

//	public void setDemandes(List<Demande> demandes) {
//		this.demandes = demandes;
//	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

//	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
//		this.utilisateurs = utilisateurs;
//	}
	public boolean isDonneur() {
		return donneur;
	}
	public void setDonneur(boolean donneur) {
		this.donneur = donneur;
	}
	public boolean isBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(boolean beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public void addDon(Don don) {
		this.dons.add(don);
		don.setEntite(this);
	}

	public void addDemande(Demande demande) {
		this.demandes.add(demande);
		demande.setEntite(this);
	}

	public void addUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
		utilisateur.setEntite(this);
	}
	
	public void addAdresse(Adresse adresse) {
		this.adresses.add(adresse);
		adresse.setEntite(this);
	}
	

	@Override
	public String toString() {
		return "Entite [id=" + id + ", nom=" + nom + ", donneur=" + donneur + ", beneficiaire=" + beneficiaire + "]";
	}
	

}
