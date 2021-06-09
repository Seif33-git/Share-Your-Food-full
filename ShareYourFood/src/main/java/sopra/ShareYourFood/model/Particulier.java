package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Particulier")
public class Particulier extends Entite {

	@Column(name = "prenom", length = 45)
	private String prenom;

	@Column(name = "age")
	private Integer age;

	public Particulier() {
		super();
	}

	public Particulier(String prenom, Integer age) {
		super();
		this.prenom = prenom;
		this.age = age;
	}

	public Particulier(String nom, boolean donneur, boolean beneficiaire, String prenom, Integer age) {
		super(nom, donneur, beneficiaire);
		this.prenom = prenom;
		this.age = age;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
