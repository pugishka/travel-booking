package ift3911_tp3.Reservation_Paiement;

import java.time.LocalDateTime;

public class Reservation {
	private LocalDateTime time;
	private int n_reservation;
	
	public Reservation() {
		this.n_reservation = ReservationIdManager.getInstance().generateID();
	}
	
	public LocalDateTime getTime() {
		return this.time;
	}
	
	public int getNumero() {
		return this.n_reservation;
	}
}
