package ift3911_tp3.Place;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

import ift3911_tp3.Reservation_Paiement.Confirmation;
import ift3911_tp3.Reservation_Paiement.Reservation;

public class PlaceReservee implements EtatPlace {
	
	private Reservation reservation;
	
	public PlaceReservee() {
		this.reservation = new Reservation();
	}

	public int reserver(Place context) {
		LocalDateTime current = LocalDateTime.now();
		Duration diff = Duration.between(current, this.reservation.getTime());
		if (diff.toHours() >= 24) {
			this.reservation = new Reservation();
			return this.reservation.getNumero();
		}
		return -1;
	}

	public boolean acheter(Place context) {
		PlaceConfirmee newEtat = new PlaceConfirmee(this.reservation.getNumero(), context.getPrix());
		context.setEtat(newEtat);
		return true;
	}
	
	public Reservation getReservation() {
		return this.reservation;
	}

	public Confirmation getConfirmation() {
		return null;
	}

}
