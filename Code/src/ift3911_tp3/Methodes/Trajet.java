package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;
import ift3911_tp3.Place.Cote;
import ift3911_tp3.Place.SectionVolTrain;
import ift3911_tp3.Place.Siege;
import ift3911_tp3.Utilisateurs.Utilisateur;

public class Trajet implements Methode{
	private LocalDateTime dateDepart;
	private LocalDateTime dateArrivee;
	private List<Destination> destinations;
	private Compagnie compagnie;
	private EtatTrajet etatTrajet;
	private List<Utilisateur> observers = new ArrayList<>();
	
	public Trajet(
			LocalDateTime dateDepart,
			LocalDateTime dateArrivee,
			List<Destination> destinations,
			Compagnie compagnie) {
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.destinations = destinations;
		this.compagnie = compagnie;

		etatTrajet = new EtatTrajet(dateDepart, dateArrivee, destinations);
	}
	public void attach(Utilisateur utilisateur){
		observers.add(utilisateur);
	}
	public void notifyAllObservers(){
		for(Utilisateur utilisateur : observers){
			utilisateur.update();
		}
	}
	
	//TODO
	public List<Siege> searchSieges(SectionVolTrain classe){
		return null;
	}
	
	public Siege getSiege(int[] disposition){
		return null;
	}
	
	public Siege getSiegeDispo(Cote preference) {
		return null;
	}
	
	// getter setter

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.etatTrajet.setDateDepart(dateDepart);
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.etatTrajet.setDateArrivee(dateArrivee);
		this.dateArrivee = dateArrivee;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.etatTrajet.setDestinations(destinations);
		this.destinations = destinations;
	}

	@Override
	public State getState() {
		return etatTrajet;
	}
	public void setState(State state) {
		this.etatTrajet = (EtatTrajet) state;

	}


	public void setEtatTrajet(EtatTrajet etatTrajet) {
		this.etatTrajet = etatTrajet;
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