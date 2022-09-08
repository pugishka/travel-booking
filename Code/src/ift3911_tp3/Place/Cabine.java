package ift3911_tp3.Place;

import ift3911_tp3.Compagnies.Compagnie;
import ift3911_tp3.StrategiePaiement.PriceCalculator;
import ift3911_tp3.StrategiePaiement.PrixCabine;

public class Cabine extends Place{
	private SectionCabine section;
	private Compagnie compagnie;
	private float prix;
	private PrixCabine prixCabine;
	
	public Cabine(SectionCabine section, Compagnie compagnie, PrixCabine prixCabine){
		this.compagnie = compagnie;
		this.section = section;
		this.prixCabine = prixCabine;
	}


	public SectionCabine getSection() {
		return this.section;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	@Override
	public float getPrix() {
		return super.getPrix();
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void calculatePrice(){
		prixCabine.calculatePrice(this);
	}
}
