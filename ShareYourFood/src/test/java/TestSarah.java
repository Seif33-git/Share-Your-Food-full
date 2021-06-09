import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Destinataire;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entite;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IProduitLotRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestSarah {
	
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
	public void entiteCreate() throws ParseException {	
		
		Entite entite1 = new Entite("Leclerc",true,false);
		
		entite1 = entiteRepo.save(entite1);
		
		Optional<Entite> entiteFind = entiteRepo.findById(entite1.getId());
		Assert.assertEquals("Leclerc", entiteFind.get().getNom());
		Assert.assertEquals(true, entiteFind.get().isDonneur());
		Assert.assertEquals(false, entiteFind.get().isBeneficiaire());
		
		entiteRepo.delete(entite1);		
	}
		
	@Test
	public void entiteUpdate() throws ParseException {
		
		Entite entite1 = new Entite("Leclerc",true,false);
		
		entite1 = entiteRepo.save(entite1);
		
		Optional<Entite> entiteFind = entiteRepo.findById(entite1.getId());
		
		entite1.setNom("Leclerc");
		Assert.assertEquals("Leclerc", entiteFind.get().getNom());
		entite1.setDonneur(false);
		Assert.assertEquals(true, entiteFind.get().isDonneur());
		entite1.setBeneficiaire(true);
		Assert.assertEquals(false, entiteFind.get().isBeneficiaire());
		
		entiteRepo.delete(entite1);			
	}	
	
	@Test
	public void adresseCreate() throws ParseException {	
				
		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		
		Optional<Adresse> adrfind = adresseRepo.findById(adrLeclerc.getId());
		Assert.assertEquals("50 avenue Gutemberg", adrfind.get().getRue());
		Assert.assertEquals("Zone commerciale Soleil", adrfind.get().getComplement());
		Assert.assertEquals("33700", adrfind.get().getCodePostal());
		Assert.assertEquals("Mérignac", adrfind.get().getVille());
		
		adresseRepo.delete(adrLeclerc);		
	}
	
	
	@Test
	public void adresseUpdate() throws ParseException {

		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		
		Optional<Adresse> adrfind = adresseRepo.findById(adrLeclerc.getId());
		
		adrLeclerc.setRue("52 avenue Gutemberg");		
		adrLeclerc.setComplement("Zone commerciale Soleil");		
		adrLeclerc.setCodePostal("33150");		
		adrLeclerc.setVille("Cenon");
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		adrfind = adresseRepo.findById(adrLeclerc.getId());
				
		Assert.assertEquals("52 avenue Gutemberg", adrfind.get().getRue());
		Assert.assertEquals("Zone commerciale Soleil", adrfind.get().getComplement());
		Assert.assertEquals("33150", adrfind.get().getCodePostal());
		Assert.assertEquals("Cenon", adrfind.get().getVille());
		
		adresseRepo.delete(adrLeclerc);			
	}	


	@Test
	public void donCreate() throws ParseException {	
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Don donLeclerc = new Don(sdf.parse("24/05/2021"),"de 13h à 15h","DLC à peine passée, mais encore en bon état",Destinataire.ASSOCIATION);
		
		donLeclerc = donRepo.save(donLeclerc);
		
		Optional<Don> donfind = donRepo.findById(donLeclerc.getId());
		
		Assert.assertEquals(sdf.parse("24/05/2021"), donfind.get().getDateDeMiseEnLigne());
		Assert.assertEquals("de 13h à 15h", donfind.get().getCreneau());
		Assert.assertEquals("DLC à peine passée, mais encore en bon état", donfind.get().getCommentaire());
		Assert.assertEquals(Destinataire.ASSOCIATION, donfind.get().getDestinataire());
		
		donRepo.delete(donLeclerc);		
	}
	
	
	@Test
	public void donUpdate() throws ParseException {
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Don donLeclerc = new Don(sdf.parse("24/05/2021"),"de 13h à 15h","DLC à peine passée, mais encore en bon état",Destinataire.ASSOCIATION);
		
		donLeclerc = donRepo.save(donLeclerc);		
		Optional<Don> donfind = donRepo.findById(donLeclerc.getId());
		
		donLeclerc.setDateDeMiseEnLigne(sdf.parse("24/05/2021"));	
		donLeclerc.setCreneau("de 14h à 15h");
		donLeclerc.setCommentaire("DLC à peine passée, mais encore en bon état");		
		donLeclerc.setDestinataire(Destinataire.ASSOCIATION);	
		
		donLeclerc = donRepo.save(donLeclerc);		
		donfind = donRepo.findById(donLeclerc.getId());
		
		Assert.assertEquals(sdf.parse("24/05/2021"), donfind.get().getDateDeMiseEnLigne());
		Assert.assertEquals("de 14h à 15h", donfind.get().getCreneau());
		Assert.assertEquals("DLC à peine passée, mais encore en bon état", donfind.get().getCommentaire());
		Assert.assertEquals(Destinataire.ASSOCIATION, donfind.get().getDestinataire());
		
		donRepo.delete(donLeclerc);			
	}

}
