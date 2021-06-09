
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.Produit;
import sopra.ShareYourFood.model.ProduitLot;
import sopra.ShareYourFood.model.Type;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IProduitLotRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;


public class TestUnitaire {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:application-context.xml");
	
	IDemandeRepository demandeRepo = context.getBean(IDemandeRepository .class);
	IDonRepository donRepo = context.getBean(IDonRepository .class);
	IEntiteRepository entiteRepo = context.getBean(IEntiteRepository .class);
	ILotRepository lotRepo = context.getBean(ILotRepository .class);
	IProduitRepository produitRepo = context.getBean(IProduitRepository .class);
	IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository .class);
	IMessageRepository messageRepo = context.getBean(IMessageRepository .class);
	IAdresseRepository adresseRepo = context.getBean(IAdresseRepository .class);
	IProduitLotRepository produitLotRepo = context.getBean(IProduitLotRepository .class);

	@Test
	public void testProduitFindById() {
		
		Produit yaourt = new Produit();
		yaourt.setNom("yaourt");
		yaourt.setType(Type.valueOf("FRAIS"));
		
		yaourt =produitRepo.save(yaourt);
		
		Optional<Produit> yaourtATester = produitRepo.findById(yaourt.getNom());

		Assert.assertEquals("yaourt", yaourtATester.get().getNom());
		
		produitRepo.delete(yaourt);
		
	}
	@Test
	public void testProduitFindAll() {
		
		Produit yaourt = new Produit();
		yaourt.setNom("yaourt");
		yaourt.setType(Type.valueOf("FRAIS"));
		
		Produit croissant = new Produit();
		croissant.setNom("pain");
		croissant.setType(Type.valueOf("PAIN_PATISSERIE"));

		yaourt =produitRepo.save(yaourt);
		croissant = produitRepo.save(croissant);
		
		List<Produit> produits = produitRepo.findAll();
		
		Assert.assertEquals(2L,produits.size());
		
		produitRepo.delete(yaourt);
		produitRepo.delete(croissant);
		
	}
	@Test
	public void testProduitLotFindById() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		ProduitLot yaourt_lot1 = new ProduitLot();
		yaourt_lot1.setQuantite(1000L);
		
		yaourt_lot1 = produitLotRepo.save(yaourt_lot1);
		Optional<ProduitLot> produitLotATester = produitLotRepo.findById(yaourt_lot1.getId());
		
		Long a = 1000L;
		Long b = produitLotATester.get().getQuantite();
		Assert.assertEquals(a, b);
		
		
		produitLotRepo.delete(yaourt_lot1);
		
	}
	@Test
	public void testProduitLotFindAll() {
		
		ProduitLot yaourt_lot1 = new ProduitLot();
		yaourt_lot1.setQuantite(1000L);

		
		ProduitLot yaourt_lot2 = new ProduitLot();
		yaourt_lot2.setQuantite(2000L);

		yaourt_lot1 = produitLotRepo.save(yaourt_lot1);
		yaourt_lot2 = produitLotRepo.save(yaourt_lot2);
		
		List<ProduitLot> produitLots = produitLotRepo.findAll();
		
		System.out.println(yaourt_lot1.getId());
		System.out.println(produitLots);
		Long a = 2L;
		Long b = (long) produitLots.size();
		
		Assert.assertEquals(a,b);
		
		produitLotRepo.delete(yaourt_lot1);
		produitLotRepo.delete(yaourt_lot2);
		
	}	
	@Test
	public void testLotFindById() {

		Lot lotNumber1 = new Lot();
		lotNumber1.setNom("Yaourt à gogo");
		lotNumber1.setVolume(400L);
		lotNumber1.setPhoto("C:/mesPhotos");
		
		lotNumber1 = lotRepo.save(lotNumber1);
		Optional<Lot> lotATester = lotRepo.findById(lotNumber1.getId());
		
		Assert.assertEquals("Yaourt à gogo", lotATester.get().getNom());
		
		lotRepo.delete(lotNumber1);
		
	}
	@Test
	public void testLotFindAll() {
	
		Lot lotNumber1 = new Lot();
		lotNumber1.setNom("Yaourt à gogo");
		lotNumber1.setVolume(400L);
		lotNumber1.setPhoto("C:/mesPhotos");
		
		Lot lotNumber2 = new Lot();
		lotNumber2.setNom("Yaourt à gogo");
		lotNumber2.setVolume(400L);
		lotNumber2.setPhoto("C:/mesPhotos");

		lotNumber1 = lotRepo.save(lotNumber1);
		lotNumber2 = lotRepo.save(lotNumber2);
		
		List<Lot> lots = lotRepo.findAll();
		
		Assert.assertEquals(2L,lots.size());
		
		lotRepo.delete(lotNumber1);
		lotRepo.delete(lotNumber2);
		
	}
}
