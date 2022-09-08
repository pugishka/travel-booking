package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Compagnies.DataBaseCompagnies;
import ift3911_tp3.Destinations.DataBaseDestinations;
import ift3911_tp3.Destinations.Destination;

public class DataBaseMethodes {

	private static List<Methode> vols;
	private static List<Methode> itineraires;
	private static List<Methode> trajets;
	private static DataBaseMethodes instance;
	
	private DataBaseMethodes() {
		vols = new ArrayList<Methode>();
		itineraires = new ArrayList<Methode>();
		trajets = new ArrayList<Methode>();
	};
	
	public static DataBaseMethodes getInstance() {
		if (instance == null) {
			instance = new DataBaseMethodes();
		}
		return instance;
	}

	public boolean newVol(LocalDateTime dateDepart, LocalDateTime dateArrivee, String[] destinations, String compagnie) {
		Compagnie co = DataBaseCompagnies.getInstance().getCompagnie(1, compagnie);
		List<Destination> d = new ArrayList<Destination>();
		for(String s : destinations) {
			d.add(DataBaseDestinations.getInstance().getDestination(1, s));
		}
		MethodeCreator c = VolCreator.getInstance();
		Methode u = c.render(dateDepart, dateArrivee, d, co);
		vols.add(u);
		return true;
	}

	public boolean newItineraire(LocalDateTime dateDepart, LocalDateTime dateArrivee, String[] destinations, String compagnie) {
		Compagnie co = DataBaseCompagnies.getInstance().getCompagnie(2, compagnie);
		List<Destination> d = new ArrayList<Destination>();
		for(String s : destinations) {
			d.add(DataBaseDestinations.getInstance().getDestination(2, s));
		}
		MethodeCreator c = ItineraireCreator.getInstance();
		Methode u = c.render(dateDepart, dateArrivee, d, co);
		itineraires.add(u);
		return true;
	}

	public boolean newTrajet(LocalDateTime dateDepart, LocalDateTime dateArrivee, String[] destinations, String compagnie) {
		Compagnie co = DataBaseCompagnies.getInstance().getCompagnie(3, compagnie);
		List<Destination> d = new ArrayList<Destination>();
		for(String s : destinations) {
			d.add(DataBaseDestinations.getInstance().getDestination(3, s));
		}
		MethodeCreator c = TrajetCreator.getInstance();
		Methode u = c.render(dateDepart, dateArrivee, d, co);
		trajets.add(u);
		return true;
	}
	
	public String [][] getVols(){
		List<String[]> liste = new ArrayList<String[]>();
		for(Methode m : vols) {
			liste.add(m.toStringList());
		}
        String[][] matrix = new String[liste.size()][];
		return liste.toArray(matrix);
	}
	
}
