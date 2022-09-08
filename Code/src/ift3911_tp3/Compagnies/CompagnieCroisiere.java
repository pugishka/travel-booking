package ift3911_tp3.Compagnies;

public class CompagnieCroisiere implements Compagnie{
	private String id;
	private String nom;
	private float seatPrice;
	
	public CompagnieCroisiere(String id, String nom, float seatPrice) {
		this.id = id;
		this.nom = nom;
		this.seatPrice = seatPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}
}
