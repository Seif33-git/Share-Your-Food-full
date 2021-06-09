package sopra.ShareYourFood.model;



public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewEntite extends ViewCommon {}
	
	public static class ViewParticulier extends ViewEntite {}
	
	public static class ViewParticulierDetail extends ViewParticulier {}
	
	public static class ViewAssociation extends ViewEntite {}
	
	public static class ViewAssociationDetail extends ViewParticulier {}
	
	public static class ViewEntreprise extends ViewEntite {}
	
	public static class ViewEntrepriseDetail extends ViewParticulier {}
	
}
