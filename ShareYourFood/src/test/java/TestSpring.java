

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.repository.IEntiteRepository;


public class TestSpring {
	@Test
	public void loadSpringXml() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IEntiteRepository entiteRepo = context.getBean(IEntiteRepository.class);
		
		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);
		
		
		context.close();
	}
	
}