package ift3911_tp3.Place;

import ift3911_tp3.Reservation_Paiement.Confirmation;
import ift3911_tp3.Reservation_Paiement.Reservation;

public class PlaceLibre implements EtatPlace {

	public int reserver(Place context) {
		PlaceReservee newEtat = new PlaceReservee();
		context.setEtat(newEtat);
		return newEtat.getReservation().getNumero();
	}

	public boolean acheter(Place context) {
		return false;
	}

	public Confirmation getConfirmation() {
		return null;
	}

	public Reservation getReservation() {
		return null;
	}

}
