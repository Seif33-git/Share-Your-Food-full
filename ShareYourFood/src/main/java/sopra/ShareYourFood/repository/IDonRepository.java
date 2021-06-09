package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Don;

public interface IDonRepository extends JpaRepository<Don, Long> {

	//List<Don> findAllJeRecois(String ville);

}
