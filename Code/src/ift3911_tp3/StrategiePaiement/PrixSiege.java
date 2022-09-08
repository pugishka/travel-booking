package ift3911_tp3.StrategiePaiement;

import ift3911_tp3.Place.Place;
import ift3911_tp3.Place.Siege;

public class PrixSiege implements PriceCalculator{
    private float priceA = 0.75f;
    private float priceE = 0.50f;
    private float priceF = 1.00f;
    private float priceP = 0.60f;
    @Override
    public void calculatePrice(Place place) {
        Siege siege = (Siege)place;
        switch(siege.getSection()) {
            case A :
                siege.setPrix(siege.getCompagnie().getSeatPrice()*priceA);
                break;
            case E:
                siege.setPrix(siege.getCompagnie().getSeatPrice()*priceE);
                break;
            case F:
                siege.setPrix(siege.getCompagnie().getSeatPrice()*priceF);
                break;
            case P:
                siege.setPrix(siege.getCompagnie().getSeatPrice()*priceP);
                break;
        }
    }



}
