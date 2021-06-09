package sopra.ShareYourFood.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewMessage extends ViewCommon{}
	public class ViewMessageWithDemande extends ViewMessage{}
	
	public static class ViewEntite extends ViewCommon{}
	
	public static class ViewDemande extends ViewCommon{}
	public class ViewDemandeWithLot extends ViewDemande{}
	public class ViewDemandeWithEntite  extends ViewDemande{}
}
