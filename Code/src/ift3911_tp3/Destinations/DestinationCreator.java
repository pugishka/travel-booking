package ift3911_tp3.Destinations;

public abstract class DestinationCreator {
	
	protected abstract Destination createDestination(String id, String ville);
	
	public Destination render (String id, String ville) {
		return createDestination(id, ville);
	};
}
