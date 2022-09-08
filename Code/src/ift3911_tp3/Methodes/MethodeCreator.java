package ift3911_tp3.Methodes;
import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;

import java.time.LocalDateTime;
import java.util.List;

public abstract class MethodeCreator {
	
	protected abstract Methode createMethode(
			LocalDateTime dateDepart, 
			LocalDateTime dateArrivee,
			List<Destination> destinations,
			Compagnie compagnie);
	
	public Methode render (
			LocalDateTime dateDepart, 
			LocalDateTime dateArrivee,
			List<Destination> destinations,
			Compagnie compagnie) {
		
		return createMethode(dateDepart, dateArrivee, destinations, compagnie);
	};
}
