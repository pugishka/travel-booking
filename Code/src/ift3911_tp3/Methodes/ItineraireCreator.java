package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;

public class ItineraireCreator extends MethodeCreator{
	
	private static ItineraireCreator instance;
	
	private ItineraireCreator() {};

	protected Methode createMethode(LocalDateTime dateDepart, LocalDateTime dateArrivee,
			List<Destination> destinations, Compagnie compagnie) {
		
		return new Itineraire(dateDepart, dateArrivee, destinations, compagnie);
	}
	
	public static ItineraireCreator getInstance() {
		if (instance == null) {
			instance = new ItineraireCreator();
		}
		return instance;
	}

}
