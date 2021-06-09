package sopra.ShareYourFood.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import sopra.ShareYourFood.model.Demande;;


public interface IDemandeRepository extends JpaRepository<Demande, Long> {

	// Afficher toutes les demandes ayant des messages et le statut ACCEPTER
	// findAlldAndStatutAccepte

//	@Query("select distinct d from Demande d left join fetch d.message.id where d.statutNotif = sopra.ShareYourFood.model.StatutNotif.ACCEPTER and demande.entite.id = :idEntite")
//	Optional<Demande> findAllDemandeWithMessagesEtQuiOntLeStatutAccepteByEntiteById(@Param("idEntite") Long idEntite);

//	@Query("select distinct d from Demande d left join fetch d.message where d.id = :id")
//	Optional<Demande> findDemandeByIdWithMessage(@Param("id") Long id);
	
}
