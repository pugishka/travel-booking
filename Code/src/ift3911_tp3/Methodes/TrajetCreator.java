package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;

public class TrajetCreator extends MethodeCreator{
	
	private static TrajetCreator instance;
	
	private TrajetCreator() {};


	protected Methode createMethode(LocalDateTime dateDepart, LocalDateTime dateArrivee,
			List<Destination> destinations, Compagnie compagnie) {
		
		return new Trajet(dateDepart, dateArrivee, destinations, compagnie);
	}
	
	public static TrajetCreator getInstance() {
		if (instance == null) {
			instance = new TrajetCreator();
		}
		return instance;
	}

}
