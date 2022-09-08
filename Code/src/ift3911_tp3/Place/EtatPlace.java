package ift3911_tp3.Place;

import ift3911_tp3.Reservation_Paiement.Confirmation;
import ift3911_tp3.Reservation_Paiement.Reservation;

public interface EtatPlace {
	public int reserver(Place context);
	public boolean acheter(Place context);
	public Confirmation getConfirmation();
	public Reservation getReservation();
}
