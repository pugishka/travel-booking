package ift3911_tp3.Methodes;

import java.time.LocalDateTime;
import java.util.List;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Destinations.Destination;
import ift3911_tp3.Utilisateurs.Utilisateur;

public interface Methode {

	public LocalDateTime getDateDepart();

	public void setDateDepart(LocalDateTime dateDepart);

	public LocalDateTime getDateArrivee();

	public void setDateArrivee(LocalDateTime dateArrivee);

	public List<Destination> getDestinations();

	public void setDestinations(List<Destination> destinations);
	
	public Compagnie getCompagnie();
	
	public void setCompagnie(Compagnie compagnie);

	public State getState();

	public void setState(State state);

	public void attach(Utilisateur utilisateur);
	public void notifyAllObservers();

	public String[] toStringList();


}
