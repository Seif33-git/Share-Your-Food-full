package sopra.ShareYourFood.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewProduit extends ViewCommon{}
	
	public static class ViewUtilisateur extends ViewCommon{}
	
	public static class ViewLot extends ViewCommon{}
	
	public static class ViewDon extends ViewCommon{}
	
	public static class ViewMessage extends ViewCommon{}
	public class ViewMessageWithDemande extends ViewMessage{}
	
	public static class ViewEntite extends ViewCommon{}
	
	public static class ViewDemande extends ViewCommon{}
	public class ViewDemandeWithLot extends ViewDemande{}
	public class ViewDemandeWithEntite  extends ViewDemande{}

	public static class ViewParticulier extends ViewEntite {}
	public static class ViewParticulierDetail extends ViewParticulier {}
	public static class ViewAssociation extends ViewEntite {}
	public static class ViewAssociationDetail extends ViewParticulier {}
	public static class ViewEntreprise extends ViewEntite {}
	public static class ViewEntrepriseDetail extends ViewParticulier {}
}