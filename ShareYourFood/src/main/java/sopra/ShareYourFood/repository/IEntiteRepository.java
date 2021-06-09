package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Entite;

public interface IEntiteRepository extends JpaRepository<Entite, Long>{

	//public Entite findByNom(String nom);

}
