package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Demande;

public interface IDemandeRepository extends JpaRepository <Demande, Long> {

}
