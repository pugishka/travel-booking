package ift3911_tp3.Place;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.StrategiePaiement.PrixSiege;

public class Siege extends Place{
	private SectionVolTrain section;
	private int[] emplacement; 		// [rang�e, colonne]
	private Cote cote;
	private Compagnie compagnie;
	private float prix;
	private PrixSiege prixSiege;
	
	public Siege(SectionVolTrain section, int[] emplacement, Cote cote, Compagnie compagnie, PrixSiege prixSiege) {
		this.section = section;
		this.emplacement = emplacement;
		this.cote = cote;
		this.compagnie = compagnie;
		this.prixSiege = prixSiege;
	}
	
	public SectionVolTrain getSection() {
		return this.section;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	@Override
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void calculatePrice(){
		prixSiege.calculatePrice(this);
	}


}
