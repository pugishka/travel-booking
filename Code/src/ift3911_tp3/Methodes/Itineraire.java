package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;
import ift3911_tp3.Place.Cabine;
import ift3911_tp3.Place.SectionCabine;
import ift3911_tp3.Utilisateurs.Utilisateur;

public class Itineraire implements Methode{
	private LocalDateTime dateDepart; 
	private LocalDateTime dateArrivee;
	private List<Destination> destinations;
	private Compagnie compagnie;
	private EtatItineraire etatItineraire;
	private List<Utilisateur> observers = new ArrayList<>();
	
	public Itineraire(
			LocalDateTime dateDepart, 
			LocalDateTime dateArrivee,
			List<Destination> destinations,
			Compagnie compagnie) {
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.destinations = destinations;
		this.compagnie = compagnie;
		
		etatItineraire = new EtatItineraire(dateDepart, dateArrivee, destinations);

	}
	
	// TODO
	public List<Cabine> searchCabines(SectionCabine classe){
		return null;
	} 
	
	
	// getter setter

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.etatItineraire.setDateDepart(dateDepart);
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.etatItineraire.setDateArrivee(dateArrivee);
		this.dateArrivee = dateArrivee;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.etatItineraire.setDestinations(destinations);
		this.destinations = destinations;
	}

	@Override
	public State getState() {
		return etatItineraire;
	}

	@Override
	public void setState(State state) {
		this.etatItineraire = (EtatItineraire) state;
	}

	public void attach(Utilisateur utilisateur){
		observers.add(utilisateur);
	}
	public void notifyAllObservers(){
		for(Utilisateur utilisateur : observers){
			utilisateur.update();
		}
	}

	public void setEtatItineraire(EtatItineraire etatItineraire) {
		this.etatItineraire = etatItineraire;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@Override
	public String[] toStringList() {
		// TODO Auto-generated method stub
		return null;
	}
}
