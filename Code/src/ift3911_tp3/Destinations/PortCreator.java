package ift3911_tp3.Destinations;

public class PortCreator extends DestinationCreator{
	
	private static PortCreator instance;
	
	private PortCreator() {};
	
	protected Destination createDestination(String id, String ville) {
		return new Aeroport(id, ville);
	}
	
	public static PortCreator getInstance() {
		if (instance == null) {
			instance = new PortCreator();
		}
		return instance;
	}

}
