import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Categorie;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.model.Destinataire;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entite;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Utilisateur;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IProduitLotRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestAube {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

	IDemandeRepository demandeRepo = context.getBean(IDemandeRepository.class);
	IDonRepository donRepo = context.getBean(IDonRepository.class);
	IEntiteRepository entiteRepo = context.getBean(IEntiteRepository.class);
	ILotRepository lotRepo = context.getBean(ILotRepository.class);
	IProduitRepository produitRepo = context.getBean(IProduitRepository.class);
	IUtilisateurRepository utilisateurRepo = context.getBean(IUtilisateurRepository.class);
	IMessageRepository messageRepo = context.getBean(IMessageRepository.class);
	IAdresseRepository adresseRepo = context.getBean(IAdresseRepository.class);
	IProduitLotRepository produitLotRepo = context.getBean(IProduitLotRepository.class);

	@Test
	public void CreateParticulier() {

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);

		Optional<Entite> aubeEntiteFind = entiteRepo.findById(aubeEntite.getId());
		if (aubeEntiteFind.isPresent()) {
			Assert.assertEquals("PECQUE", aubeEntiteFind.get().getNom());
		} else {
			System.out.println("Not found");
		}

		entiteRepo.delete(aubeEntite);

		Particulier aubeEntite2 = new Particulier("PECQUE", true, false, "Aubeline", 28);

		aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite2);

		entiteRepo.delete(aubeEntite2);

	}

	@Test
	public void CreateAssociation() {
		

		Association croixRougeEntite = new Association("FR123456789", "justificatif1");
		croixRougeEntite.setNom("La Croix Rouge");
		croixRougeEntite.setDonneur(true);
		croixRougeEntite.setBeneficiaire(true);
		croixRougeEntite = (Association) entiteRepo.save(croixRougeEntite);

		Optional<Entite> croixRougeEntiteFind = entiteRepo.findById(croixRougeEntite.getId());
		if (croixRougeEntiteFind.isPresent()) {
			Assert.assertEquals("La Croix Rouge", croixRougeEntiteFind.get().getNom());
			Assert.assertEquals("FR123456789", ((Association) croixRougeEntiteFind.get()).getNumeroAssociation());
			Assert.assertEquals("justificatif1", ((Association) croixRougeEntiteFind.get()).getJustificatif());
			Assert.assertEquals(true, croixRougeEntiteFind.get().isDonneur());
			Assert.assertEquals(true, croixRougeEntiteFind.get().isBeneficiaire());
		} else {
			System.out.println("Not found");
		}

		entiteRepo.delete(croixRougeEntite);
	}

	@Test
	public void CreateEntreprise() {

		Entreprise leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		leclerc.setNom("Leclerc");
		leclerc.setDonneur(true);
		leclerc.setBeneficiaire(false);
		leclerc = (Entreprise) entiteRepo.save(leclerc);

		Optional<Entite> leclercFind = entiteRepo.findById(leclerc.getId());
		if (leclercFind.isPresent()) {
			Assert.assertEquals("5486935JH14S", ((Entreprise) leclercFind.get()).getSiret());
			Assert.assertEquals(Categorie.GRANDE_SURFACE, ((Entreprise) leclercFind.get()).getCategorie());
			Assert.assertEquals("Leclerc", leclercFind.get().getNom());
			Assert.assertEquals(true, leclercFind.get().isDonneur());
			Assert.assertEquals(false, leclercFind.get().isBeneficiaire());
		} else {
			System.out.println("Not found");
		}

		entiteRepo.delete(leclerc);
	}

	@Test
	public void updateParticulier() {
		

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);

		aubeEntite.setPrenom("aubeliiiiine");
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);

		Assert.assertEquals("aubeliiiiine", aubeEntite.getPrenom());

		entiteRepo.delete(aubeEntite);
	}

	@Test
	public void addAdresseEntite() {
		

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);

		Adresse adrAube = new Adresse("500 impasse Olympie", "Batiment A", "64000", "Pau");
		//aubeEntite.addAdresse(adrAube);
		Particulier aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite);

		entiteRepo.delete(aubeEntite2);

	}

	@Test
	public void addDonEntite() throws ParseException {
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);

		Adresse adrAube = new Adresse("1 impasse Olympie", "Batiment A", "64000", "Pau");

		//aubeEntite.addAdresse(adrAube);

		Don donAubeline = new Don();
		donAubeline.setDateDeMiseEnLigne(sdf.parse("24/05/2021"));
		donAubeline.setCreneau("Entre 12h et 14h");
		donAubeline.setCommentaire("Pas d'urgence");
		donAubeline.setDestinataire(Destinataire.PARTICULIER);
		donAubeline.setAdresse(adrAube);

		aubeEntite.addDon(donAubeline);

		Particulier aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite);

		entiteRepo.delete(aubeEntite2);
	}

	@Test
	public void addDemandeEntite() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);

		Adresse adrAube = new Adresse("999 impasse Olympie", "Batiment A", "64000", "Pau");

	//	aubeEntite.addAdresse(adrAube);

		Demande jeVeuxDesPates = new Demande();
		jeVeuxDesPates.setDtDemande(sdf.parse("24/05/2021"));

		aubeEntite.addDemande(jeVeuxDesPates);

		Particulier aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite);

		entiteRepo.delete(aubeEntite2);
	}

	@Test
	public void addUtilisateurEntite() {
		


		Association croixRougeEntite = new Association("FR123456789", "justificatif1");
		croixRougeEntite.setNom("La Croix Rouge");
		croixRougeEntite.setDonneur(true);
		croixRougeEntite.setBeneficiaire(true);
		croixRougeEntite = (Association) entiteRepo.save(croixRougeEntite);

		Adresse adrCroixRouge = new Adresse("9 avenue Gambetta", null, "13001", "Marseille");
	//	croixRougeEntite.addAdresse(adrCroixRouge);

		Utilisateur benevoleCroixRouge1 = new Utilisateur();
		benevoleCroixRouge1.setPseudo("Toto65");
		benevoleCroixRouge1.setMotDePasse("azerty123");
		benevoleCroixRouge1.setMail("toto65@gmail.com");
		benevoleCroixRouge1.setMessagerieActivation(true);

		croixRougeEntite.addUtilisateur(benevoleCroixRouge1);

		Association croixRougeEntite2 = (Association) entiteRepo.save(croixRougeEntite);

		entiteRepo.delete(croixRougeEntite2);
	}

}