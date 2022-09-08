package ift3911_tp3.Compagnies;

import java.util.ArrayList;
import java.util.List;

public class DataBaseCompagnies {

	private static List<Compagnie> aerienne;
	private static List<Compagnie> navale;
	private static List<Compagnie> ferroviaire;
	private static DataBaseCompagnies instance;
	
	private DataBaseCompagnies() {
		aerienne = new ArrayList<Compagnie>();
		navale = new ArrayList<Compagnie>();
		ferroviaire = new ArrayList<Compagnie>();
	};
	
	public static DataBaseCompagnies getInstance() {
		if (instance == null) {
			instance = new DataBaseCompagnies();
		}
		return instance;
	}

	public boolean newCompagnieAerienne(String nom, String id, float prix) {
		CompagnieCreator c = CompagnieAerienneCreator.getInstance();
		Compagnie u = c.render(nom, id, prix);
		aerienne.add(u);
		return true;
	}

	public boolean newCompagnieCroisiere(String nom, String id, float prix) {
		CompagnieCreator c = CompagnieCroisiereCreator.getInstance();
		Compagnie u = c.render(nom, id, prix);
		navale.add(u);
		return true;
	}

	public boolean newCompagnieFerroviaire(String nom, String id, float prix) {
		CompagnieCreator c = CompagnieFerroviaireCreator.getInstance();
		Compagnie u = c.render(nom, id, prix);
		ferroviaire.add(u);
		return true;
	}

	public boolean checkCompagnieAerienne(String id) {
		for(Compagnie u : aerienne) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean checkCompagnieCroisiere(String id) {
		for(Compagnie u : navale) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public boolean checkCompagnieFerroviaire(String id) {
		for(Compagnie u : ferroviaire) {
			if(u.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public Compagnie getCompagnie(int type, String id) {
		if (type == 1){
			for(Compagnie u : aerienne) {
				if(u.getId() == id) {
					return u;
				}
			}
		}
		if (type == 2){
			for(Compagnie u : navale) {
				if(u.getId() == id) {
					return u;
				}
			}
		}
		if (type == 3){
			for(Compagnie u : ferroviaire) {
				if(u.getId() == id) {
					return u;
				}
			}
		}
		return null;
	}
	
	
}
