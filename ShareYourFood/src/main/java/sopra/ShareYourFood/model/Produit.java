package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "produit")

public class Produit {
	@Id
	@Column(name = "nom")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	@JsonView(Views.ViewCommon.class)
	private Type type;
	
	@OneToMany(mappedBy = "produit")
	private List<ProduitLot> produitLots = new ArrayList<ProduitLot>();

	public Produit() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<ProduitLot> getProduitLots() {
		return produitLots;
	}

	public void setProduitLots(List<ProduitLot> produitLots) {
		this.produitLots = produitLots;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
