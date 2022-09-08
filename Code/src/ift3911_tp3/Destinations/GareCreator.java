package ift3911_tp3.Destinations;

public class GareCreator extends DestinationCreator{
	
	private static GareCreator instance;
	
	private GareCreator() {};
	
	protected Destination createDestination(String id, String ville) {
		return new Aeroport(id, ville);
	}
	
	public static GareCreator getInstance() {
		if (instance == null) {
			instance = new GareCreator();
		}
		return instance;
	}

}
