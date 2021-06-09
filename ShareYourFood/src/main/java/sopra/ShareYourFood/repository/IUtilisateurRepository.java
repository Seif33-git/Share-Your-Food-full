package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
