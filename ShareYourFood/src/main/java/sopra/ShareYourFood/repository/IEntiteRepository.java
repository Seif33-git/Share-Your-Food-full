package sopra.ShareYourFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Entite;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Particulier;


public interface IEntiteRepository extends JpaRepository<Entite, Long>{

	List<Particulier> findAllParticulier(); // NamedQuery : Particulier.findAllParticulier
	
	List<Association> findAllAssociation(); // NamedQuery : Association.findAllAssociation
	
	List<Entreprise> findAllEntreprise(); // NamedQuery : Entreprise.findAllEntreprise
	

}
