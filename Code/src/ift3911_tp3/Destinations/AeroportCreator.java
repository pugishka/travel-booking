package ift3911_tp3.Destinations;

public class AeroportCreator extends DestinationCreator{
	
	private static AeroportCreator instance;
	
	private AeroportCreator() {};
	
	protected Destination createDestination(String id, String ville) {
		return new Aeroport(id, ville);
	}
	
	public static AeroportCreator getInstance() {
		if (instance == null) {
			instance = new AeroportCreator();
		}
		return instance;
	}

}
