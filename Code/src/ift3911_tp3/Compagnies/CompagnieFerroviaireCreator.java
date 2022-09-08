package ift3911_tp3.Compagnies;

public class CompagnieFerroviaireCreator extends CompagnieCreator{
	
	private static CompagnieFerroviaireCreator instance;
	
	private CompagnieFerroviaireCreator() {};
	
	protected Compagnie createCompagnie(String id, String nom, float seatPrice) {
		return new CompagnieFerroviaire(id, nom, seatPrice);
	}
	
	public static CompagnieFerroviaireCreator getInstance() {
		if (instance == null) {
			instance = new CompagnieFerroviaireCreator();
		}
		return instance;
	}
}
