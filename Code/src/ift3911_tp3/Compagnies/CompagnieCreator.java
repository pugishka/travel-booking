package ift3911_tp3.Compagnies;

public abstract class CompagnieCreator {
	
	protected abstract Compagnie createCompagnie(String id, String nom, float seatPrice);
	
	public Compagnie render (String id, String nom, float seatPrice) {
		return createCompagnie(id, nom, seatPrice);
	};
}
