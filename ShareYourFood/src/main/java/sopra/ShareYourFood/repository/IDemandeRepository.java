package sopra.ShareYourFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.ShareYourFood.model.Demande;

public interface IDemandeRepository extends JpaRepository <Demande, Long> {

	
	@Query("select d from Demande d where d.statutNotif = sopra.ShareYourFood.model.StatutNotif.ACCEPTER and "
			+ "d.entite.id = :idEntite") //, d.lot.don.entite.nom une seule sortie ? 
	List<Demande> findAllAccepterEtNomCorrespondantByEntiteByIdIfBeneficiaire(@Param("idEntite") Long idEntite);
	
	@Query("select d from Demande d where d.statutNotif = sopra.ShareYourFood.model.StatutNotif.ACCEPTER and "
			+ "d.lot.don.entite.id = :idEntite ")
	List<Demande> findAllAccepterEtNomCorrespondantByEntiteByIdIfDonneur(@Param("idEntite") Long idEntite);
	
	@Query("select d from Demande d where d.statutNotif = sopra.ShareYourFood.model.StatutNotif.ARCHIVER and "
			+ "d.entite.id = :idEntite ")
	List<Demande> findAllArchiverEtNomCorrespondantByEntiteByIdIfBeneficiaire(@Param("idEntite") Long idEntite);
	
	@Query("select d from Demande d where d.statutNotif = sopra.ShareYourFood.model.StatutNotif.ARCHIVER and "
			+ "d.lot.don.entite.id = :idEntite ")
	List<Demande> findAllArchiverEtNomCorrespondantByEntiteByIdIfDonneur(@Param("idEntite") Long idEntite);
}
