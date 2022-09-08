package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;
import ift3911_tp3.Place.Cote;
import ift3911_tp3.Place.SectionVolTrain;
import ift3911_tp3.Place.Siege;
import ift3911_tp3.Utilisateurs.Utilisateur;

public class Vol implements Methode{
	private String id;
	private LocalDateTime dateDepart;
	private LocalDateTime dateArrivee;
	private List<Destination> destinations;
	private List<SectionVolTrain> sections;
	private Compagnie compagnie;
	private EtatVol etatVol;
	private List<Utilisateur> observers = new ArrayList<>();

	
	public Vol(
			LocalDateTime dateDepart,
			LocalDateTime dateArrivee,
			List<Destination> destinations,
			Compagnie compagnie) {
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.destinations = destinations;
		this.compagnie = compagnie;

		etatVol = new EtatVol(dateDepart, dateArrivee, destinations, sections);
		// TODO
		setId("");
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.etatVol.setDateDepart(dateDepart);
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.etatVol.setDateArrivee(dateArrivee);
		this.dateArrivee = dateArrivee;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.etatVol.setDestinations(destinations);
		this.destinations = destinations;
	}

	@Override
	public State getState() {
		return etatVol;
	}

	@Override
	public void setState(State state) {
		this.etatVol = (EtatVol) state;
	}

	public void attach(Utilisateur utilisateur){
		observers.add(utilisateur);
	}
	public void notifyAllObservers(){
		for(Utilisateur utilisateur : observers){
			utilisateur.update();
		}
	}

	public List<SectionVolTrain> getSections() {
		return sections;
	}

	public void setSections(List<SectionVolTrain> sections) {
		this.etatVol.setSections(sections);
		this.sections = sections;
	}


	public Compagnie getCompagnie() {
		return compagnie;
	}


	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}
	
	public String[] toStringList() {
		String[] l = {this.id, this.compagnie.getId(), this.dateDepart.toString(), this.dateArrivee.toString(), this.destinations.get(0).getId(), this.destinations.get(1).getId(), };
		return l;
	}


}