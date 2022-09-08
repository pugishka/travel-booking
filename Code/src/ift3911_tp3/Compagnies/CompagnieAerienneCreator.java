package ift3911_tp3.Compagnies;

public class CompagnieAerienneCreator extends CompagnieCreator{
	
	private static CompagnieAerienneCreator instance;
	
	private CompagnieAerienneCreator() {};
	
	protected Compagnie createCompagnie(String id, String nom, float seatPrice) {
		return new CompagnieAerienne(id, nom, seatPrice);
	}
	
	public static CompagnieAerienneCreator getInstance() {
		if (instance == null) {
			instance = new CompagnieAerienneCreator();
		}
		return instance;
	}

}
