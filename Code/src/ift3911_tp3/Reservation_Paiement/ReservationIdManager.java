package ift3911_tp3.Reservation_Paiement;

public class ReservationIdManager {
	
	private static ReservationIdManager _instance = new ReservationIdManager();
	private int lastID;
	
	private ReservationIdManager() {
		this.lastID = -1;
	}
	
	public static ReservationIdManager getInstance() {
		return _instance;
	}
	public int generateID() {
		return ++this.lastID;
	}
	
	//public static void main(String[] args) {
	//	ReservationIdManager manager = new ReservationIdManager();
	//}
	
}

