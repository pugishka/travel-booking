package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;

public class VolCreator extends MethodeCreator{
	
	private static VolCreator instance;
	
	private VolCreator() {};

	protected Methode createMethode(LocalDateTime dateDepart, LocalDateTime dateArrivee,
			List<Destination> destinations, Compagnie compagnie) {
		
		return new Vol(dateDepart, dateArrivee, destinations, compagnie);
	}
	
	public static VolCreator getInstance() {
		if (instance == null) {
			instance = new VolCreator();
		}
		return instance;
	}

}
