package ift3911_tp3.Place;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.Reservation_Paiement.Confirmation;
import ift3911_tp3.Reservation_Paiement.Reservation;

public class Place {
	private EtatPlace etat;
	private float prix;
	private Compagnie compagnie;

	
	public int reserver() {
		return etat.reserver(this);
	}
	
	public boolean acheter () {
		return etat.acheter(this);
	}
	
	public Confirmation getConfirmation() {
		return etat.getConfirmation();
	}
	
	public Reservation getReservation() {
		return etat.getReservation();
	}
	
	public void setEtat(EtatPlace etat) {
		this.etat = etat;
	}
	
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}
}
