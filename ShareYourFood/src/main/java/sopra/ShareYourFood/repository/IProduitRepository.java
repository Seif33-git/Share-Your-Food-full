package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, String>{

}
