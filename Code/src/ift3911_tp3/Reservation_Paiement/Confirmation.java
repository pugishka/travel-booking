package ift3911_tp3.Reservation_Paiement;

import java.util.Scanner;

public class Confirmation {
	private int n_reservation;
	private String nom;
	private String courriel;
	private float prix;
	private Paiement paiement;
	
	public Confirmation(int n, float p) {
		this.n_reservation = n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez votre nom :");
		this.nom = scanner.nextLine();
		System.out.println("Entrez votre courriel :");
		this.courriel = scanner.nextLine();
		scanner.close();
		this.prix = p;
		this.paiement = new Paiement(this.prix);
	}
	
	public int getNumero() {
		return this.n_reservation;
	}
	
	public int getPrix() {
		return this.n_reservation;
	}
	
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public void setPaiement(Paiement p) {
		this.paiement = p;
	}
}
