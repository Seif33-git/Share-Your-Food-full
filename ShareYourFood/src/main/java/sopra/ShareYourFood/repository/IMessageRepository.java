package sopra.ShareYourFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.ShareYourFood.model.Message;

public interface IMessageRepository extends JpaRepository <Message, Long>{
	
//	@Query("select m from Message m where m.donneur = false and "
//			+ "m.demande.lot.id = :idLot")
//	Message findByDemande(@Param("idLot") Long idLot);

	
	@Query("select m from Message where m.demande.id = :idDemande")
	List<Message> findAllPourUneDemande(@Param("idDemande") Long idDemande);
	}
