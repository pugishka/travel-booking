package ift3911_tp3.Place;

import ift3911_tp3.Reservation_Paiement.Confirmation;
import ift3911_tp3.Reservation_Paiement.Reservation;

public class PlaceConfirmee implements EtatPlace {
	
	private Confirmation confirmation;
	
	public PlaceConfirmee(int n, float p) {
		this.confirmation = new Confirmation(n, p);
	}

	public int reserver(Place context) {
		return -1;
	}

	public boolean acheter(Place context) {
		return false;
	}
	
	public Confirmation getConfirmation() {
		return this.confirmation;
	}
	
	public void setConfirmation(Confirmation c) {
		this.confirmation = c;
	}

	public Reservation getReservation() {
		return null;
	}

}
