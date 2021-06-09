import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Categorie;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.model.Destinataire;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.Message;
import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Produit;
import sopra.ShareYourFood.model.Statut;
import sopra.ShareYourFood.model.Type;
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

public class TestJpaWithDaoAube {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
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
		
		
		// Entites
		// Particulier
		
		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);
		
		Adresse adrAube = new Adresse("2 impasse Olympie", "Batiment A", "64000", "Pau");
		adrAube.setEntite(aubeEntite);
		adrAube = adresseRepo.save(adrAube);

		Utilisateur aubeUtilisateur = new Utilisateur();
		aubeUtilisateur.setPseudo("Aube");
		aubeUtilisateur.setMotDePasse("azerty1234");
		aubeUtilisateur.setMail("aubeline.pecque@hotmail.com");
		aubeUtilisateur.setMessagerieActivation(true);
		aubeUtilisateur.setEntite(aubeEntite);
		aubeUtilisateur = utilisateurRepo.save(aubeUtilisateur);

		Don donAubeline = new Don();
		donAubeline.setDateDeMiseEnLigne(sdf.parse("24/05/2021"));
		donAubeline.setCreneau("Entre 12h et 14h");
		donAubeline.setCommentaire("Pas d'urgence");
		donAubeline.setDestinataire(Destinataire.PARTICULIER);
		donAubeline.setEntite(aubeEntite);
//		donAubeline.setAdresse(adresseRepo.findById(adrAube.getId()));
		donAubeline.setAdresse(adrAube);
		donAubeline = donRepo.save(donAubeline);

		Produit pates = new Produit();
		pates.setNom("pates");
		pates.setType(Type.EPICERIE_SALE);
		pates = produitRepo.save(pates);

		// dans un lot j'ai 1 don, une liste de produitLots et une liste de demandes
		Lot lotDuDonAubeline = new Lot();
		lotDuDonAubeline.setNom("Lot de pates");
		lotDuDonAubeline.setVolume((long) 1);
		lotDuDonAubeline.setDtPeremptionLot(sdf.parse("01/01/2025"));
		lotDuDonAubeline.setStatut(Statut.DISPONIBLE);
		lotDuDonAubeline.setDon(donAubeline);
		lotDuDonAubeline = lotRepo.save(lotDuDonAubeline);
//		ProduitLot patesLot = new ProduitLot();
//		patesLot.setDtPeremption(sdf.parse("01/01/2025"));
//		patesLot.setQuantite((long) 1);
//		patesLot.setProduit(pates);
//		patesLot.setLot(lotDuDonAubeline);
//		lotDuDonAubeline.addProduitLot(patesLot);
//		lotDuDonAubeline = lotRepo.save(lotDuDonAubeline);

//***********************************************

		Particulier sarahEntite = new Particulier("sarah", 25);
		sarahEntite.setNom("CAZE");
		sarahEntite.setDonneur(true);
		sarahEntite.setBeneficiaire(true);
		sarahEntite = (Particulier) entiteRepo.save(sarahEntite);
		
		Adresse adrSarah = new Adresse("75 rue d'Athènes", "bis", "33000", "Bordeaux");
		adrSarah.setEntite(sarahEntite);
		adrSarah = adresseRepo.save(adrSarah);

		Utilisateur sarahUtilisateur = new Utilisateur();
		sarahUtilisateur.setPseudo("SarahCZE");
		sarahUtilisateur.setMotDePasse("azerty12345");
		sarahUtilisateur.setMail("sarah.caze@hotmail.com");
		sarahUtilisateur.setMessagerieActivation(true);
		sarahUtilisateur.setEntite(sarahEntite);
		sarahUtilisateur = utilisateurRepo.save(sarahUtilisateur);

		Demande jeVeuxDesPates = new Demande();
		jeVeuxDesPates.setDtDemande(sdf.parse("24/05/2021"));
		jeVeuxDesPates.setEntite(sarahEntite);
		jeVeuxDesPates.setLot(lotDuDonAubeline);
		jeVeuxDesPates = demandeRepo.save(jeVeuxDesPates);

		Message messageJeVeuxDesPates = new Message();
		messageJeVeuxDesPates.setContenu("Bonjour, j'ai besoin de pates svp");
		messageJeVeuxDesPates.setDonneur(true);
		messageJeVeuxDesPates.setDemande(jeVeuxDesPates);
		messageJeVeuxDesPates = messageRepo.save(messageJeVeuxDesPates);

		// Association

		Association croixRougeEntite = new Association("FR123456789", "justificatif1");
		croixRougeEntite.setNom("La Croix Rouge");
		croixRougeEntite.setDonneur(true);
		croixRougeEntite.setBeneficiaire(true);
		croixRougeEntite = (Association) entiteRepo.save(croixRougeEntite);

		Adresse adrCroixRouge = new Adresse("9 avenue Gambetta", null, "13001", "Marseille");
		adrCroixRouge.setEntite(croixRougeEntite);
		adrCroixRouge = adresseRepo.save(adrCroixRouge);

		Utilisateur benevoleCroixRouge1 = new Utilisateur();
		benevoleCroixRouge1.setPseudo("Toto65");
		benevoleCroixRouge1.setMotDePasse("azerty123");
		benevoleCroixRouge1.setMail("toto65@gmail.com");
		benevoleCroixRouge1.setMessagerieActivation(true);
		benevoleCroixRouge1.setEntite(croixRougeEntite);
		benevoleCroixRouge1 = utilisateurRepo.save(benevoleCroixRouge1);

		Utilisateur benevoleCroixRouge2 = new Utilisateur();
		benevoleCroixRouge2.setPseudo("TotoAssos");
		benevoleCroixRouge2.setMotDePasse("azerty123987");
		benevoleCroixRouge2.setMail("totoAssos@gmail.com");
		benevoleCroixRouge2.setMessagerieActivation(true);
		benevoleCroixRouge2.setEntite(croixRougeEntite);
		benevoleCroixRouge2 = utilisateurRepo.save(benevoleCroixRouge2);

		Association donPourTous = new Association("FR987654321", "justificatif2");
		donPourTous.setNom("Dons pour tous");
		donPourTous.setDonneur(false);
		donPourTous.setBeneficiaire(true);
		donPourTous = (Association) entiteRepo.save(donPourTous);
		
		Adresse adrDonPourTous = new Adresse("277 boulevard Leon Blum", "Bâtiment C", "75004", "Paris");
		adrDonPourTous.setEntite(donPourTous);
		adrDonPourTous = adresseRepo.save(adrDonPourTous);

		Utilisateur benevoleDonPourTous1 = new Utilisateur();
		benevoleDonPourTous1.setPseudo("ReSi");
		benevoleDonPourTous1.setMotDePasse("qsdfgh");
		benevoleDonPourTous1.setMail("regis.simon@hotmail.com");
		benevoleDonPourTous1.setMessagerieActivation(true);
		benevoleDonPourTous1.setEntite(donPourTous);
		benevoleDonPourTous1 = utilisateurRepo.save(benevoleDonPourTous1);
		


		// Entreprise

		Entreprise leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		leclerc.setNom("Leclerc");
		leclerc.setDonneur(true);
		leclerc.setBeneficiaire(false);
		leclerc = (Entreprise) entiteRepo.save(leclerc);

		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		adrLeclerc.setEntite(leclerc);
		adrLeclerc = adresseRepo.save(adrLeclerc);

		Utilisateur employeLeclerc1 = new Utilisateur();
		employeLeclerc1.setPseudo("Coco_du_06");
		employeLeclerc1.setMotDePasse("azerty");
		employeLeclerc1.setMail("cocodu06@gmail.com");
		employeLeclerc1.setMessagerieActivation(true);
		employeLeclerc1.setEntite(leclerc);
		employeLeclerc1 = utilisateurRepo.save(employeLeclerc1);

//		Don donLeclerc = new Don();
//		try {
//			donLeclerc.setDateDeMiseEnLigne(sdf.parse("02/09/2020"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		donLeclerc.setCreneau("13h à 15h");
//		donLeclerc.setCommentaire("DLC à peine passée, mais encore en bon état");
//		donLeclerc.setDestinataire(Destinataire.ASSOCIATION);
//		donLeclerc.setAdresse(adrLeclerc);
//		
//		donRepo.save(donLeclerc); 
//		
//		
//		Lot chocolat = new Lot();
//		chocolat.setNom("Chocolat");
//		try {
//			chocolat.setDtPeremptionLot(sdf.parse("05/07/2022"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		chocolat.setPhoto("djvbv/didz/yugi");
//		chocolat.setVolume((long) 50);
//		chocolat.setStatut(Statut.DISPONIBLE);
//		chocolat.setDon(donLeclerc);
//		
//		Lot pain = new Lot();
//		chocolat.setNom("Pain");
//		try {
//			chocolat.setDtPeremptionLot(sdf.parse("20/05/2023"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		pain.setPhoto("djvbv/didz/yugi");
//		pain.setVolume((long) 25);
//		pain.setStatut(Statut.DISPONIBLE);
//		pain.setDon(donLeclerc);
//		
//		lotRepo.save(pain);
//		lotRepo.save(chocolat);
//		
//		
//		Demande demandeDonPourTous = new Demande();
//		try {
//			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		demandeDonPourTous.setLot(pain);
//		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeDonPourTous.setEntite(DonPourTous);
//		
//		Demande demandeRegis = new Demande();
//		try {
//			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		demandeRegis.setLot(chocolat);
//		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeRegis.setEntite(regis);
//		
//		demandeRepo.save(demandeRegis);
//		demandeRepo.save(demandeDonPourTous);
//		
//		sopra.ShareYourFood.model.Message messageDonPourTousLeclerc = new sopra.ShareYourFood.model.Message();
//		messageDonPourTousLeclerc.setContenu("Bonjour, Don Pour Tous souhaiterai bénéficier de ce don. Nous vous remercions par avance.");
//		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
//		messageDonPourTousLeclerc.setDonneur(false);
//		
//		sopra.ShareYourFood.model.Message messageLeclercDonPourTous = new sopra.ShareYourFood.model.Message();
//		messageLeclercDonPourTous.setContenu("Bien volontiers");
//		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
//		messageLeclercDonPourTous.setDonneur(true);
//		
//		
//		sopra.ShareYourFood.model.Message messageRegis = new sopra.ShareYourFood.model.Message();
//		messageRegis.setContenu("Bonjour, est-il possible de disposer de chocolat ? Bien à vous");
//		messageRegis.setDemande(demandeRegis);
//		messageRegis.setDonneur(false);
//		
//		sopra.ShareYourFood.model.Message messageLeclercRegis = new sopra.ShareYourFood.model.Message();
//		messageLeclercRegis.setContenu("Bien sur");
//		messageLeclercRegis.setDemande(demandeRegis);
//		messageLeclercRegis.setDonneur(true);
//		
//		messageRepo.save(messageDonPourTousLeclerc);
//		messageRepo.save(messageLeclercDonPourTous);
//		messageRepo.save(messageRegis);
//		messageRepo.save(messageLeclercRegis);
//		
//		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
//		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
//		messageRegis.setDemande(demandeRegis);
//		messageLeclercRegis.setDemande(demandeRegis);
//		
//
	}

}
