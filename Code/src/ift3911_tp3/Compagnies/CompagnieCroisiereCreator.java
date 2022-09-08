package ift3911_tp3.Compagnies;

public class CompagnieCroisiereCreator extends CompagnieCreator{
	
	private static CompagnieCroisiereCreator instance;
	
	private CompagnieCroisiereCreator() {};
	
	protected Compagnie createCompagnie(String id, String nom, float seatPrice) {
		return new CompagnieCroisiere(id, nom, seatPrice);
	}
	
	public static CompagnieCroisiereCreator getInstance() {
		if (instance == null) {
			instance = new CompagnieCroisiereCreator();
		}
		return instance;
	}
}
